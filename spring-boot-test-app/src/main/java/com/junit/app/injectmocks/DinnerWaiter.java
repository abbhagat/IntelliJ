package com.junit.app.injectmocks;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DinnerWaiter {

    public List<String> getMeatMenu(){
        return Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
    }

    public List<String> getVegetarianMenu(){
        return Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
    }

}
