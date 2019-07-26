package com.rabbit.demo;

import com.rabbit.demo.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {

        MsgProducer msgProducer=new MsgProducer(rabbitTemplate);
        for (int i = 0; i < 100; i++) {
            msgProducer.sendMsg("Hello RabbitMQ,这是我发送的第"+i+"条消息A");
        }

    }

}
