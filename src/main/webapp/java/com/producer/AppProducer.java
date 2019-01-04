package com.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for(int i=0;i<10;i++) {
            service.sendMessage("哈哈哈 queue" + i);
        }
        ((ClassPathXmlApplicationContext) context).close();
    }
}
