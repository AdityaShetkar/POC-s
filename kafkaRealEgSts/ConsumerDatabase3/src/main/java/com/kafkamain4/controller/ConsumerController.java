package com.kafkamain4.controller;

import com.kafkamain4.service.KafkaDatabaseConsumer3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private KafkaDatabaseConsumer3 consumer;

    @GetMapping
    @KafkaListener(
            topics = "testtopic",
            groupId = "myGroupss"
    )
    public void consume(String eventMessage){
        this.consumer.consume(eventMessage);
    }
}
