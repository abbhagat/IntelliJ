package lld.shoppingcart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShoppingCartImpl {

  public static void main(String[] args) throws Exception {
    InventoryService inventoryService = new InventoryService();
    Product iphone =  new Product("P101", "iPhone 16", 1000);
    // Only 10 items in stock
    inventoryService.addStock("P101", 10);
    ShoppingCart user1Cart = new ShoppingCart("USER-1");
    ShoppingCart user2Cart = new ShoppingCart("USER-2");
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(() -> {
      if (inventoryService.reserve("P101", 10)) {
        user1Cart.addItem(iphone, 10);
        System.out.println(
            "USER-1 successfully added 10 items");
      } else {
        System.out.println("USER-1 failed. Out of stock.");
      }
    });
    executor.submit(() -> {
      if (inventoryService.reserve("P101", 10)) {
        user2Cart.addItem(iphone, 10);
        System.out.println("USER-2 successfully added 10 items");
      } else {
        System.out.println("USER-2 failed. Out of stock.");
      }
    });

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);
    System.out.println("--------------------------------");
    System.out.println("Remaining Inventory : " + inventoryService.getAvailableQty("P101"));
    System.out.println("User1 Cart : " + user1Cart.getCartItemMap());
    System.out.println("User2 Cart : "  + user2Cart.getCartItemMap());
  }
}
