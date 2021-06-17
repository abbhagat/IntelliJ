package org.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping(value = "/")
    public String home(){
        return "<H1>Welcome</H1>";
    }

    @GetMapping(value = "/user")
    public String user(){
        return "<H1>Welcome User</H1>";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "<H1>Welcome Admin</H1>";
    }
}
