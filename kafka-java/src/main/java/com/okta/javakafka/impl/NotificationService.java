package com.okta.javakafka.impl;

import com.okta.javakafka.model.NotificationServiceRequest;
import com.okta.javakafka.model.NotificationServiceResponse;
import com.okta.javakafka.service.INotificationService;

public class NotificationService implements INotificationService {

//    @Autowired
//    INotificationService notificationServiceClient;

    @Override
    public void createAlert(String message, String mobile) {

        NotificationServiceRequest req = new NotificationServiceRequest();
        req.setMessage(message);
        req.setMobile(mobile);

        NotificationServiceResponse response = new NotificationServiceResponse();
        String url = "google.com";

        try {
//            response = client.executeRequest(url, req, NotificationServiceResponse.class);
        } catch (Exception e) {
//            reponse = this.getErrorResponse(mobile);
        }
    }



}
