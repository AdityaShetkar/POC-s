package com.kafkamain4.service;


import com.kafkamain4.entity.Wikimedia1;
import com.kafkamain4.repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer1.class);
    private WikimediaDataRepo wikimediaDataRepo;

    public KafkaDatabaseConsumer1(WikimediaDataRepo wikimediaDataRepo) {
        this.wikimediaDataRepo = wikimediaDataRepo;
    }


    public void consume(String eventMessage) {
//        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        Wikimedia1 wikimedia = new Wikimedia1();
        wikimedia.setWikiEventData(eventMessage);

        wikimediaDataRepo.save(wikimedia);
    }
}
