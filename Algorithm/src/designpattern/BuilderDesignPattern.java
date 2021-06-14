package designpattern;

/**
 * In builder design pattern we build a complex object using simple object and uses step by step approach.
 */

import java.util.ArrayList;
import java.util.List;

interface Item {
    String name();
    float price();
    Packing packing();
}

interface Packing {
    String pack();
}

class Wrapper implements Packing {
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements Item {
    public Packing packing() {
        return new Wrapper();
    }
}

abstract class ColdDrink implements Item {

    public Packing packing() {
        return new Bottle();
    }
}

class VegBurger extends Burger {

    public float price() {
        return 25.0f;
    }

    public String name() {
        return "Veg Burger";
    }
}

class ChickenBurger extends Burger {

    public float price() {
        return 50.0f;
    }

    public String name() {
        return "Chicken Burger";
    }
}

class Coke extends ColdDrink {

    public float price() {
        return 30.0f;
    }

    public String name() {
        return "Coke";
    }
}

class Pepsi extends ColdDrink {

    public float price() {
        return 35.0f;
    }

    public String name() {
        return "Pepsi";
    }
}

class Meal {

    private List<Item> items;

    public Meal(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        items.forEach(item -> System.out.print("Item : " + item.name() + ", Packing : " + item.packing().pack() + ", Price : " + item.price()));
    }
}

class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal(new ArrayList<>());
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal(new ArrayList<>());
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

public class BuilderDesignPattern {
    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        // Prepare Veg Meal
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        // Prepare Non Veg Meal
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
