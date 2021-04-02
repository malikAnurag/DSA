package com.okta.javakafka.consumer;

import com.okta.javakafka.dao.PagerDao;
import com.okta.javakafka.entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * This class is responsible for listening to changes inside the myTopic topic
 */

@Component
public class MyTopicConsumer {
    private final List<String> messages = new ArrayList<>();

    @Autowired
    PagerDao pagerDao;

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            Developer developer = pagerDao.getDeveloperFromTeamId(Integer.parseInt(message));
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}