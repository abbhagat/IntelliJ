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
    itemMap.compute(product.productId, (k, v) -> {
      if (v == null) return new CartItem(product, qty);
      v.quantity += qty;
      return v;
    });
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
