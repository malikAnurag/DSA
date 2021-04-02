package com.okta.javakafka.dao;

import com.okta.javakafka.entity.Developer;
import com.okta.javakafka.entity.Team;

import java.util.List;

public interface PagerDao {

    boolean createTeam(Team team, List<Developer> developers);

    Developer getDeveloperFromTeamId(int teamId);
}
