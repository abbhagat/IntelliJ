package org.spring.aop.service;

import lombok.Getter;
import lombok.Setter;
import org.spring.aop.shape.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Shape {

    @Autowired
    private Triangle triangle;

}
