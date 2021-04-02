package com.okta.javakafka.impl;

import com.okta.javakafka.dao.PagerDao;
import com.okta.javakafka.model.CreateTeamRequest;
import com.okta.javakafka.model.CreateTeamResponse;
import com.okta.javakafka.service.IPagerDutyService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pagerDutyService")
public class PagerDutyService implements IPagerDutyService {

    @Autowired
    PagerDao pagerDao;

    private static final String INVALID_REQUEST = "Invalid Request";

    @Override
    public CreateTeamResponse createTeam(CreateTeamRequest createTeamRequest) {

        CreateTeamResponse response = new CreateTeamResponse();

        if(!validateRequest(createTeamRequest)) {
            response.setMessage(INVALID_REQUEST);
            response.setSuccessful(false);
            return response;
        }
        try {
            boolean isSuccess = pagerDao.createTeam(createTeamRequest.getTeam(), createTeamRequest.getDeveloperList());
            response.setSuccessful(isSuccess);
        } catch (Exception e) {
//            Log.error("Exception occurred while creating team with team name :: {}" , createTeamRequest.getTeam().getName(), e);
            response.setSuccessful(false);
            response.setMessage("Exception occurred while creating team :: " +  e.getClass());
        }
        return response;
    }

    private boolean validateRequest(CreateTeamRequest request) {
        if(request == null || request.getTeam() == null || request.getDeveloperList().isEmpty()) {

            return false;
        }
        return true;
    }
}
