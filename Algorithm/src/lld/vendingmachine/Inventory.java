package lld.vendingmachine;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Inventory {

  private final Map<String, Item> inventory = new HashMap<>();

  public void addProduct(Product product, int quantity) {
    inventory.put(product.name(), new Item(product, quantity));
  }

  public Item getItem(String productName) {
    return inventory.get(productName);
  }

  public void refill(Product product, int quantity) {
    Item item = inventory.computeIfAbsent(product.name(), value -> new Item(product, 0));
    item.setQuantity(item.getQuantity() + quantity);
  }
}
