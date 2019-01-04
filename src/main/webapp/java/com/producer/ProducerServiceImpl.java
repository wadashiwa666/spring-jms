package com.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    //此部分可切换topic和queue
    @Resource(name = "topicDestination")//有可能配置多个，所以用资源加name的方式进行区分这个是xml中的目的地Id
    Destination destination;
    //使用jmsTemplate发送消息
    public void sendMessage(final String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            //创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.println("发送消息： " + msg);
    }
}
