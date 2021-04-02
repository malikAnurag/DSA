package com.okta.javakafka.model;

import com.okta.javakafka.entity.Developer;
import com.okta.javakafka.entity.Team;

import java.io.Serializable;
import java.util.List;

public class CreateTeamRequest implements Serializable {

    private Team team;
    private List<Developer> developerList;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }
}
