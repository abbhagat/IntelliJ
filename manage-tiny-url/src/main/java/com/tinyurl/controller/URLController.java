package com.tinyurl.controller;

import com.tinyurl.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/url")
public class URLController {

    @Autowired
    private URLService service;

    @GetMapping(value = "/getShortURL/{longURL}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getShortURL(@PathVariable String longURL){
        return service.getShortURL(longURL);
    }

    @GetMapping(value = "/getLongURL/{shortURL}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getLongURL(@PathVariable String shortURL){
        return service.getLongURL(shortURL);
    }

}
