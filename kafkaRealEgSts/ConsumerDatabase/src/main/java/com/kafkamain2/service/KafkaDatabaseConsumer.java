package com.kafkamain2.service;

import com.kafkamain2.entity.Wikimedia;
import com.kafkamain2.repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepo wikimediaDataRepo;

    public KafkaDatabaseConsumer(WikimediaDataRepo wikimediaDataRepo) {
        this.wikimediaDataRepo = wikimediaDataRepo;
    }


    public void consume(String eventMessage) {
//        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(eventMessage);

        wikimediaDataRepo.save(wikimedia);
    }
}
