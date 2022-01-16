package com.tinyurl.service;

import com.tinyurl.dao.URLRepository;
import com.tinyurl.model.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLService {

    @Autowired
    private URLRepository dao;

    private static final String BASE_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static volatile int counter = 1;
    private static final String TINY_URL = "http://www.tinyurl.com/";

    public String getShortURL(String longURL) {
        Optional<String> shortURL = Optional.ofNullable(dao.findByLongURL(longURL));
        if (!shortURL.isPresent()) {
            URL url = new URL();
            url.setId(counter);
            url.setLongURL(longURL);
            String short_url = encodeURL(counter);
            url.setShortURL(short_url);
            counter++;
            dao.save(url);
            return short_url;
        }
        return shortURL.get();
    }

    public String getLongURL(String shortURL) {
        int id = decodeURL(shortURL);
        return dao.findById(id).get().getLongURL();
    }

    private String encodeURL(int val) {
        StringBuilder url = new StringBuilder();
        while (val != 0) {
            url.append(val % 62);
            val /= 62;
        }
        int l = url.length();
        for (int i = 1; i < 7 - l; i++) {
            url.insert(0, 0);
        }
        return TINY_URL + url;
    }

    private int decodeURL(String longURL){
        int id = 0;
        String shortURL = longURL.substring(longURL.lastIndexOf("/"));
        for(char x : shortURL.toCharArray()){
            id = id * 62 + BASE_62.indexOf(x);
        }
        return id;
    }
}
