package com.wadedwyane.www;

import com.wadedwyane.www.entity.primary.Factory;
import com.wadedwyane.www.entity.primary.FactoryRepository;
import com.wadedwyane.www.entity.secondary.Good;
import com.wadedwyane.www.entity.secondary.GoodRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootmultidatasourceApplication.class)
public class SourceDataTest {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondaryJdbcTemplate;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Test
    public void test() {
        String sql = "insert into boss(name, age) values ('zhangsan', 20)";
        String sql2 = "insert into boss(name, age) values ('lisi', 30)";
        primaryJdbcTemplate.update(sql);
        primaryJdbcTemplate.update(sql2);
        secondaryJdbcTemplate.update(sql);
    }

    @Test
    public void testJpa() {
        factoryRepository.save(new Factory("食品厂", "深圳市龙华区"));
        factoryRepository.save(new Factory("榨菜厂", "重庆市涪陵区"));
        factoryRepository.save(new Factory("粮油厂", "吉林省吉林市"));

        Assert.assertEquals(3, factoryRepository.findAll().size());

        goodRepository.save(new Good("方便面", "康师傅方便面"));
        goodRepository.save(new Good("榨菜", "乌江榨菜"));

        Assert.assertEquals(2, goodRepository.findAll().size());
    }
}
