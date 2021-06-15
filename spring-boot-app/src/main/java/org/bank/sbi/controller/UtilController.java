package org.bank.sbi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UtilController {

    @GetMapping(value = "/interceptor_error")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String interceptorError(){
        return "interceptor_error";
    }
}
