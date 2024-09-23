package com.pingidentity.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @Autowired
    private ExternalAlertService externalAlertService;

    public void notify(Order order){
        System.out.println(order);
    }

    public boolean raiseAlert(Order order){
        return externalAlertService.alert(order);
    }

}
