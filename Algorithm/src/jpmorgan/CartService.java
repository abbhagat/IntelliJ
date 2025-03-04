package jpmorgan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Map<String,Integer> itemQtyMap     =    APPLE, 10  validation
// Map<String,Integer> categoryQtyMap =    FRUIT, 20  validation

class TotalCartQty {
    int totalQtyInCart;
}

class ItemCart {

    Map<String, Integer>     itemQtyMap = new ConcurrentHashMap<>();
    Map<String, Integer> categoryQtyMap = new ConcurrentHashMap<>();
    Map<String, Map<String, Integer>> cartMap = new ConcurrentHashMap<>();

    public void addItemToCart(String item, String category, int qty, TotalCartQty totalCartQty) {
        if (cartMap.containsKey(category)) {
            int count = cartMap.get(category).get(item);
            int sumOfCategoryCount = cartMap.get(category).values().stream().reduce(0, Integer::sum);
            if (count < itemQtyMap.get(item) && sumOfCategoryCount < categoryQtyMap.get(category) && totalCartQty.totalQtyInCart < 100) {
                Map<String, Integer> tempMap = cartMap.get(category);
                totalCartQty.totalQtyInCart += qty;
                tempMap.put(item, qty);
                cartMap.put(category, tempMap);
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

    }
}
