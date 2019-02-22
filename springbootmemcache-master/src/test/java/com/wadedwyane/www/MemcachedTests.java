package com.wadedwyane.www;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedTests {

    @Autowired
    MemcachedClient memcachedClient;

    /**
     * 测试set/get/delete方法
     *
     * @throws Exception
     */
    @Test
    public void testSetGetDelete() throws Exception {
        //set:第一个参数是key
        //第二个参数是过期时间,超过这个时间,这个值将会被替换出去,0表示永久存储(默认一个月)
        //第三个参数是value,可以是任意可序列化的类型
        memcachedClient.set("hello", 0, "hello, world");
        String value = memcachedClient.get("hello");
        System.out.println("hello = " + value);
        memcachedClient.delete("hello");
    }

    /**
     * 测试更多的操作
     *
     * @throws Exception
     */
    @Test
    public void testMore() throws Exception {
        if (!memcachedClient.set("hello", 0, "today is a sunny day ")) {
            System.err.println("set error");
        }

        if (!memcachedClient.add("hello", 0, "wadedwyane")) {
            System.err.println("Add error, key is existed");
        }
        //替换掉已经存在的key的值
        if (!memcachedClient.replace("hello", 0, "replace hello")) {
            System.err.println("replace error");
        }

        //向value后面追加数据
        memcachedClient.append("hello", " , I am so happy");
        //在value前面追加数据
        memcachedClient.prepend("hello", "ladies and gentleman, ");
        String name = memcachedClient.get("hello", new StringTranscoder());
        System.out.println("name =" + name);
        //删除数据并且告诉Memcached,不用返回应答,适合批量处理
        memcachedClient.deleteWithNoReply("hello");
    }

    /**
     * 测试Incr和Decr操作,原子递增和原子递减
     *
     * @throws Exception
     */
    @Test
    public void testIncrDecr() throws Exception {
        memcachedClient.delete("Incr");
        memcachedClient.delete("Decr");
        //incr和decr都有三个参数:
        //第一个参数:key的名称
        //第二个参数:指定递增或者递减的幅度大小
        //第三个参数:指定当key不存在情况下的初始值,第三个参数不存在,初始值默认为0
        System.out.println(memcachedClient.incr("Incr", 6, 12));
        System.out.println(memcachedClient.incr("Incr", 3));
        System.out.println(memcachedClient.incr("Incr", 2));
        System.out.println(memcachedClient.decr("Decr", 1, 6));
        System.out.println(memcachedClient.decr("Decr", 2));
    }

    /**
     * 测试counter操作适合高并发抢购条件下做并发控制
     *
     * @throws Exception
     */
    @Test
    public void testCounter() throws Exception {
        Counter counter = memcachedClient.getCounter("counter", 10);
        System.out.println("counter = " + counter.get());
        //执行一次给计数器加1
        long c1 = counter.incrementAndGet();
        System.out.println("counter = " + c1);
        //执行一次给计数器减1
        long c2 = counter.decrementAndGet();
        System.out.println("counter = " + c2);
        //根据正负值来判断,底层还是incr和decr来实现
        long c3 = counter.addAndGet(-10);
        System.out.println("counter = " + c3);
    }

    /**
     * 更新缓存过期时间, memcached已经支持touch协议,只需要传递key的缓存超时时间即可
     * 如果此处报错,那么请更新到支持touch协议的memcached客户端
     *
     * @throws Exception
     */
    @Test
    public void testTouch() throws Exception {
        memcachedClient.set("touch", 2, "touch value");
        Thread.sleep(1000);
        memcachedClient.touch("touch", 6);
        Thread.sleep(2000);
        String value = memcachedClient.get("touch", 3000);
        System.out.print("touch = " + value);
    }


}
