package jpmorgan;

import lombok.Getter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Map<String,Integer> itemQtyMap     =    APPLE, 10  validation
// Map<String,Integer> categoryQtyMap =    FRUIT, 20  validation

class TotalCartQty {
    int totalQtyInCart;
}

class ItemCart {

    private static final Map<String, Integer>     itemQtyMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> categoryQtyMap = new ConcurrentHashMap<>();
    @Getter
    private final Map<String, Map<String, Integer>> cartMap = new ConcurrentHashMap<>();  // put(category,put(item,qty))

    static {
        itemQtyMap.put("APPLE", 10);
        itemQtyMap.put("BANANA", 5);
        itemQtyMap.put("ORANGE", 8);
        itemQtyMap.put("MANGO", 12);
        itemQtyMap.put("GUAVA", 12);

        categoryQtyMap.put("FRUIT", 20);
        categoryQtyMap.put("VEGETABLE", 15);
    }

    public void addItemToCart(String item, String category, int qty, TotalCartQty totalCartQty) {
        if (cartMap.containsKey(category)) {
            int sumOfCategoryCount = cartMap.get(category).values().stream().reduce(0, Integer::sum);
            int count = cartMap.get(category).getOrDefault(item, 0);
            if (count < itemQtyMap.get(item) && sumOfCategoryCount < categoryQtyMap.get(category) && totalCartQty.totalQtyInCart < 30) {
                Map<String, Integer> tempMap = cartMap.get(category);
                totalCartQty.totalQtyInCart += qty;
                tempMap.put(item, qty);
                cartMap.put(category, tempMap);
            } else {
                System.out.println("Item or category limit exceeded for item: " + item + " in category: " + category);
            }
        } else {
            Map<String, Integer> tempMap = new ConcurrentHashMap<>();
            totalCartQty.totalQtyInCart += qty;
            tempMap.put(item, qty);
            cartMap.put(category, tempMap);
        }
    }
}

public class CartService {

    public static void main(String[] args) {
        ItemCart itemCart = new ItemCart();
        TotalCartQty totalCartQty = new TotalCartQty();
        itemCart.addItemToCart("APPLE",  "FRUIT",   5, totalCartQty);
        itemCart.addItemToCart("BANANA", "FRUIT",   3, totalCartQty);
        itemCart.addItemToCart("ORANGE", "FRUIT",   2, totalCartQty);
        itemCart.addItemToCart("MANGO",  "FRUIT",  10, totalCartQty);
        itemCart.addItemToCart("GUAVA",  "FRUIT",  12, totalCartQty);
        System.out.println(itemCart.getCartMap());
        System.out.println("Total quantity in cart: " + totalCartQty.totalQtyInCart);
    }
}
