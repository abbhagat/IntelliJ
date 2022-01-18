package com.tinyurl.dao;

import com.tinyurl.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL,Integer> {

    String findByLongURL (String  longURL);
    URL    findByShortURL(String shortURL);
}
