package com.pingidentity.test;

import org.springframework.stereotype.Service;

@Service
public class ExternalAlertService {

    public boolean alert(Order order) {
        return true;
    }
}
