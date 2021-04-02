package com.okta.javakafka.service;

import com.okta.javakafka.model.CreateTeamRequest;
import com.okta.javakafka.model.CreateTeamResponse;

public interface IPagerDutyService {

    CreateTeamResponse createTeam(CreateTeamRequest createTeamRequest);

}
