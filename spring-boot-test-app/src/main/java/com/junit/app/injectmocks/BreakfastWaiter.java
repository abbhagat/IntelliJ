package com.junit.app.injectmocks;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BreakfastWaiter {

    public List<String> getMeatMenu(){
        return Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
    }

    public List<String> getVegetarianMenu(){
        return Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
    }
}
