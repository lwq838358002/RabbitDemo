package com.rabbit.demo.Receiver;

import com.rabbit.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class Receiver_One {

    private final Logger logger=LoggerFactory.getLogger(Receiver_One.class);

    @RabbitHandler
    public void process(String content){
        logger.info("处理器One接收处理队列A当中的消息"+content);
    }
}
