package com.wadedwyane.www;

import com.wadedwyane.www.entity.User;
import com.wadedwyane.www.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("host", "wadedwyane");
        Assert.assertEquals("wadedwyane", redisTemplate.opsForValue().get("host"));
    }

    /**
     * 存储实体(Object)
     */
    @Test
    public void testObj() {
        User user = new User("zhangsanfeng", 98, 1, 90, "武当山掌门人,武术高超,技艺精湛", "张无忌太爷爷");
        ValueOperations<String, User> operations =
                redisTemplate.opsForValue();
        operations.set("wds", user);
        User u = operations.get("wds");
        System.out.println("user:" + u.toString());
    }

    /**
     * 测试超时失效的问题,超过失效时间,会自动删除这个缓存
     */
    @Test
    public void testExpire() throws InterruptedException {
        User user = new User("达摩祖师", 100, 1, 92, "少林寺掌门人,来自印度,最后成了舍利子", "河南嵩山少林寺");
        ValueOperations<String, User> operations =
                redisTemplate.opsForValue();
        //这里使用MILLSECONDS作单位时,可能会报错,需要升级redis版本.
        //set方法中,可以给设置缓存时间
        operations.set("sls", user, 1, TimeUnit.SECONDS);
        Thread.sleep(2000);
        boolean exists = redisTemplate.hasKey("sls");
        if (exists) {
            System.out.println("sls 还存在");
        } else {
            System.out.println("sls 不存在");
        }

    }

    /**
     * 删除缓存
     */
    @Test
    public void testDelete() {
        redisTemplate.opsForValue().set("delete", "delete me quick");
        Boolean delete = redisTemplate.hasKey("delete");
        if (delete) {
            System.out.println("delete 存在");
        } else {
            System.out.println("delete 不存在");
        }

        redisTemplate.delete("delete");
        //删除数据
        Boolean delete2 = redisTemplate.hasKey("delete");
        if (delete2) {
            System.out.println("delete 存在");
        } else {
            System.out.println("delete 不存在");
        }
    }

    /**
     * 存储hash值,需要传入三个参数
     * 第一个参数:key
     * 第二个参数:Field,(Filed为key的相关属性)
     * 第三个参数:value
     */
    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash", "hashKey", "hash value");
        String value = (String) hash.get("hash", "hashKey");
        System.out.println("hash value :" + value);
    }

    /**
     * 存储list,可以利用List轻松实现消息队列
     * 利用push操作,将任务存入队列;利用pop操作,将任务从队列中取出
     */
    @Test
    public void testList() {
        ListOperations<String, String> operations = redisTemplate.opsForList();
        operations.leftPush("list", "www");
        operations.leftPush("list", ".wadedwyane");
        operations.leftPush("list", ".com");
        String value = operations.leftPop("list");
        System.out.println("list value : " + value);
        String value1 = operations.leftPop("list");
        System.out.println("list value : " + value1);
        String value2 = operations.leftPop("list");
        System.out.println("list value : " + value2);
    }

    /**
     * 操作set(set自动去重复)
     */
    @Test
    public void testSet() {
        String key = "";
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add(key, "www.");
        setOperations.add(key, "wadedwyane");
        setOperations.add(key, ".com");
        setOperations.add(key, "wadedwyane");
        setOperations.add(key, ".com");
        Set<String> values = setOperations.members(key);
        for (String v : values) {
            System.out.println("set value : " + v);
        }
    }

    /**
     * 测试difference()函数
     * difference()会把key1中不同于key2的数据对比出来
     */
    @Test
    public void testDifference() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key1 = "key1";
        String key2 = "key2";
        setOperations.add(key1, "miami");
        setOperations.add(key1, "dwyane");
        setOperations.add(key1, "wade");

        setOperations.add(key2, "wade");
        setOperations.add(key2, "nba");
        setOperations.add(key2, "dwyane");
        setOperations.add(key2, "bosh");

        Set<String> diffs = setOperations.difference(key1, key2);
        for (String value : diffs) {
            System.out.println("diffs set value : " + value);
        }
    }

    /**
     * 测试union()函数
     * 相当于求并集
     */
    @Test
    public void testUnions() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key3 = "setMore3";
        String key4 = "setMore4";
        set.add(key3, "it");
        set.add(key3, "you");
        set.add(key3, "xx");
        set.add(key4, "aa");
        set.add(key4, "bb");
        set.add(key4, "know");
        Set<String> unions = set.union(key3, key4);
        for (String v : unions) {
            System.out.println("unions value :" + v);
        }
    }

    @Test
    public void test() {
        redisService.set("test", "iwantyou");
        Assert.assertEquals("iwantyou", redisTemplate.opsForValue().get("test"));
    }
}
