package com.wadedwyane.www;


import com.wadedwyane.www.entity.User;
import com.wadedwyane.www.sender.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    private Sender1 sender1;

    @Autowired
    private Sender2 sender2;

    @Autowired
    private Sender3 sender3;

    @Autowired
    private Sender4 sender4;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    User user;

    @Test
    public void hello() {
        sender1.sendMessage("Hello");
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sender1.sendMessage(i + "");
        }
    }

    @Test
    public void manyToMany() throws Exception{
        for (int i = 0; i < 100; i++) {
            sender1.sendMessage(i + "");
            sender2.sendMessage(i + "");
        }
    }

    @Test
    public void sendUser() throws Exception{
        user.setName("zhangsan");
        user.setAge("23");
        sender3.sendUser(user);
    }

    @Test
    public void sendMessage() {
        sender4.send1();
        sender4.send2();
    }

    @Test
    public void sendFanoutMessage() {
       fanoutSender.send();
    }
}
