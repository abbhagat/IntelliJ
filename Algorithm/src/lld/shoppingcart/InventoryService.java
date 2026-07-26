package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {

  // ProductId -> Available Quantity
  private final Map<String, Integer> inventory = new ConcurrentHashMap<>();

  public void addStock(String productId, int qty) {
    inventory.merge(productId, qty, Integer::sum);
  }

  /**
   * Atomically reserves inventory.
   * Returns true only if enough quantity is available.
   */
  public boolean reserve(String productId, int qty) {
    return inventory.compute(productId, (id, availableQty) -> {
      if (availableQty == null || availableQty < qty) {
        return availableQty;
      }
      return availableQty - qty;
    }) != null && inventory.getOrDefault(productId, 0) >= 0;
  }

  public void release(String productId, int qty) {
    inventory.merge(productId, qty, Integer::sum);
  }

  public int getAvailableQty(String productId) {
    return inventory.getOrDefault(productId, 0);
  }
}
