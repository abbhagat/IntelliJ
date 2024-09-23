package com.junit.app.injectmocks;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class CustomerOrder {

    @Autowired
    private BreakfastWaiter breakfastWaiter;

    @Autowired
    private DinnerWaiter dinnerWaiter;

    public List<String> vegetarianBreakfast() {
        return breakfastWaiter.getVegetarianMenu();
    }

    public List<String> meatDinner() {
        return dinnerWaiter.getMeatMenu();
    }
}
