package com.soft.pubsub.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActivemqProducer  {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value("${topicname}")
    private String destinationName;

  @Scheduled(fixedDelay = 500)
    public void sendMessage() throws Exception {
        MessageCreator msgcreator=session -> session.createTextMessage("from producer:"+ LocalDateTime.now());
        jmsTemplate.send(destinationName,msgcreator);
    }
}
