package com.junit.app.injectmocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerOrderTest {

    @Mock
    BreakfastWaiter breakfastWaiter;

    @Mock
    DinnerWaiter dinnerWaiter;

    @InjectMocks
    CustomerOrder customerOrder;

    @Test
    public void testServeVegetarianBreakfast(){
        List<String> expectedBreakfast = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        when(breakfastWaiter.getVegetarianMenu()).thenReturn(Arrays.asList("Apple", "Beans", "Hash brown", "Toast"));
        List<String> actualBreakfast = customerOrder.vegetarianBreakfast();
        assertThat(expectedBreakfast, is(actualBreakfast));
    }

    @Test
    public void testServeMeatDinner(){
        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        when(dinnerWaiter.getMeatMenu()).thenReturn(Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding"));
        List<String> actualDinner = customerOrder.meatDinner();
        assertThat(expectedDinner, is(actualDinner));
    }
}
