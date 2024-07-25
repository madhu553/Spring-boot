package com.soft.activeconsumer.reader;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveReader {
    @JmsListener( destination = "${queuename}")
    public  void  readmessage( String message){
        System.out.println(message);
    }

}
