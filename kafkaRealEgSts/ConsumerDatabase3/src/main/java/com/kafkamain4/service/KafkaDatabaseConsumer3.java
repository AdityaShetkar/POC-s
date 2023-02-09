package com.kafkamain4.service;

import com.kafkamain4.entity.Wikimedia3;
import com.kafkamain4.repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer3.class);
    private WikimediaDataRepo wikimediaDataRepo;

    public KafkaDatabaseConsumer3(WikimediaDataRepo wikimediaDataRepo) {
        this.wikimediaDataRepo = wikimediaDataRepo;
    }

    public void consume(String eventMessage) {
//        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        Wikimedia3 wikimedia = new Wikimedia3();
        wikimedia.setWikiEventData(eventMessage);

        wikimediaDataRepo.save(wikimedia);
    }
}
