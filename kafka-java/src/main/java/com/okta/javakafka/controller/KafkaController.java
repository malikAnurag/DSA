package com.okta.javakafka.controller;

import com.okta.javakafka.consumer.MyTopicConsumer;
import com.okta.javakafka.entity.Developer;
import com.okta.javakafka.entity.Team;
import com.okta.javakafka.model.CreateTeamRequest;
import com.okta.javakafka.model.CreateTeamResponse;
import com.okta.javakafka.service.IPagerDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private MyTopicConsumer myTopicConsumer;

    @Autowired
    IPagerDutyService pagerDutyService;

    public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer myTopicConsumer) {
        this.template = template;
        this.myTopicConsumer = myTopicConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("myTopic", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return myTopicConsumer.getMessages();
    }

    @RequestMapping(value = "/createTeam", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public CreateTeamResponse createTeam (@RequestBody CreateTeamRequest request) {

        Team team = new Team();
        team.setName("CSK");

        List<Developer> developers = new ArrayList<>();

        Developer d1 = new Developer();
        d1.setName("Dhoni");
        d1.setNumber("12345");
        d1.setTeam(team);
        developers.add(d1);


        request.setTeam(team);
        request.setDeveloperList(developers);

        CreateTeamResponse response = pagerDutyService.createTeam(request);
        return response;
    }

}