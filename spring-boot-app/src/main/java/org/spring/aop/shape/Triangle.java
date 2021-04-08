package org.spring.aop.shape;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Triangle {

    private String name;

    public String getName() {
        System.out.println(this.name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName() called");
    }

    public String setNameAndReturn(String name) {
        this.name = name;
        System.out.println("setNameAndReturn() called");
        return name;
    }

    public void setNameAndThrowException(String name) {
        this.name = name;
        System.out.println("setNameAndThrowException() called");
        throw new RuntimeException();
    }
}
