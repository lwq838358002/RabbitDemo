package com.rabbit.demo.producer;

import com.rabbit.demo.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) throws Exception{

        CorrelationData correlationData=new CorrelationData();
        correlationData.setId(order.getMessageId());

        rabbitTemplate.convertAndSend("order-exchange",//exchange
                "order.abcd", //routingkey
                order, //消息体结构
                correlationData  );//correlationData 消息唯一ID
    }
}
