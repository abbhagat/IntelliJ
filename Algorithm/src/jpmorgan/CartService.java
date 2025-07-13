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

    private static final Map<String, Integer>     itemQtyMap  = new ConcurrentHashMap<>();
    private static final Map<String, String> itemcategoryMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> categoryQtyMap  = new ConcurrentHashMap<>();
    @Getter
    private final Map<String, Map<String, Integer>> cartMap = new ConcurrentHashMap<>();  // put(category,put(item,qty))

    static {
        itemQtyMap.put("Apple", 10);
        itemQtyMap.put("Banana", 5);
        itemQtyMap.put("Orange", 8);
        itemQtyMap.put("Mango", 12);
        itemQtyMap.put("Guava", 12);

        itemcategoryMap.put("Apple",  "Fruit");
        itemcategoryMap.put("Banana", "Fruit");
        itemcategoryMap.put("Orange", "Fruit");
        itemcategoryMap.put("Mango",  "Fruit");
        itemcategoryMap.put("Guava",  "Fruit");
        itemcategoryMap.put("Pen",    "Stationery");
        itemcategoryMap.put("Pencil", "Stationery");

        categoryQtyMap.put("Fruit", 20);
        categoryQtyMap.put("Stationery", 15);
    }

    public void addItemToCart(String item, int qty, TotalCartQty totalCartQty) {
        String category = !itemcategoryMap.isEmpty() && itemcategoryMap.containsKey(item) ? itemcategoryMap.get(item) : null;
        if (category != null && cartMap.containsKey(category)) {
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
        ItemCart itemCart         = new ItemCart();
        TotalCartQty totalCartQty = new TotalCartQty();
        itemCart.addItemToCart("Apple",  5,  totalCartQty);
        itemCart.addItemToCart("Banana", 3,  totalCartQty);
        itemCart.addItemToCart("Orange", 2,  totalCartQty);
        itemCart.addItemToCart("Mango",  10, totalCartQty);
        itemCart.addItemToCart("Guava",  12, totalCartQty);
        System.out.println(itemCart.getCartMap());
        System.out.println("Total quantity in cart: " + totalCartQty.totalQtyInCart);
    }
}
