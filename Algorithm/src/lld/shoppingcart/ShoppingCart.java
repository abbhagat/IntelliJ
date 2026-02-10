package lld.shoppingcart;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ShoppingCart {

  String userId;
  private final Map<String, CartItem> itemMap = new ConcurrentHashMap<>();

  public ShoppingCart(String userId) {
    this.userId = userId;
  }

  public void addItem(Product product, int qty) {
    String productId = product.getProductId();
    CartItem item = itemMap.get(productId);
    if (item == null) {
      item = new CartItem(product, qty);
      itemMap.put(productId, item);
    } else {
      item.quantity += qty;
    }
  }

  public void updateItem(String productId, int qty) {
    if (itemMap.containsKey(productId)) {
      if (qty <= 0) {
        itemMap.remove(productId);
      } else {
        itemMap.get(productId).quantity = qty;
      }
    }
  }

  public void removeItem(String productId) {
    itemMap.remove(productId);
  }

}
