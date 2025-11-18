package jpmorgan;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TotalCartQty {
  int totalQtyInCart;
}

class ItemCart {

  private static final Map<String, Integer> itemQtyMap = new ConcurrentHashMap<>();
  private static final Map<String, String> categoryMap = new ConcurrentHashMap<>();
  private static final Map<String, Integer> categoryQtyMap = new ConcurrentHashMap<>();

  static {
    itemQtyMap.put("Apple", 10);             // Map<String,Integer> itemQtyMap     =    APPLE, 10  validation
    itemQtyMap.put("Banana", 5);            // Map<String,Integer> categoryQtyMap  =    FRUIT, 20  validation
    itemQtyMap.put("Orange", 8);
    itemQtyMap.put("Mango", 12);
    itemQtyMap.put("Guava", 12);

    categoryMap.put("Apple", "Fruit");
    categoryMap.put("Banana", "Fruit");
    categoryMap.put("Orange", "Fruit");
    categoryMap.put("Mango", "Fruit");
    categoryMap.put("Guava", "Fruit");
    categoryMap.put("Pen", "Stationery");
    categoryMap.put("Pencil", "Stationery");
    categoryMap.put("Eraser", "Stationery");

    categoryQtyMap.put("Fruit", 20);
    categoryQtyMap.put("Stationery", 15);
  }

  @Getter
  private final Map<String, Map<String, Integer>> cartMap = new ConcurrentHashMap<>();  // put(category,put(item,qty))

  public void addItemToCart(String item, int qty, TotalCartQty totalCartQty) {

    String category = categoryMap.get(item);

    cartMap.putIfAbsent(category, new ConcurrentHashMap<>());
    Map<String, Integer> categoryItems = cartMap.get(category);

    var itemLimit = itemQtyMap.getOrDefault(item, Integer.MAX_VALUE);
    var categoryLimit = categoryQtyMap.getOrDefault(category, Integer.MAX_VALUE);
    var currentCategoryTotal = categoryItems.values().stream().reduce(0, Integer::sum);
    var currentItemCount = categoryItems.getOrDefault(item, 0);

    var withinItemLimit = currentItemCount + qty <= itemLimit;
    var withinCategoryLimit = currentCategoryTotal + qty <= categoryLimit;
    var withinCartLimit = totalCartQty.totalQtyInCart + qty <= 100;

    if (withinItemLimit && withinCategoryLimit && withinCartLimit) {
      categoryItems.put(item, currentItemCount + qty);
      totalCartQty.totalQtyInCart += qty;
    } else {
      System.out.printf("Item or category limit exceeded for item: %s in category: %s%n", item, category);
    }
  }
}

public class CartService {

  public static void main(String[] args) {
    ItemCart itemCart = new ItemCart();
    TotalCartQty totalCartQty = new TotalCartQty();
    itemCart.addItemToCart("Apple", 5, totalCartQty);
    itemCart.addItemToCart("Banana", 3, totalCartQty);
    itemCart.addItemToCart("Orange", 2, totalCartQty);
    itemCart.addItemToCart("Mango", 10, totalCartQty);
    itemCart.addItemToCart("Guava", 12, totalCartQty);
    itemCart.getCartMap().forEach((category, items) -> items.forEach((item, quantity) -> System.out.println(category + "\t" + item + "\t" + quantity)));
    System.out.println("Total quantity in cart: " + totalCartQty.totalQtyInCart);
  }
}
