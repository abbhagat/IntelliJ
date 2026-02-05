package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ShoppingCart {

  String userId;
  private Map<String, CartItem> items = new ConcurrentHashMap<>();

  public ShoppingCart(String userId) {
    this.userId = userId;
  }

  public void addItem(Product product, int qty) {
    items.compute(product.productId, (k, v) -> {
      if (v == null) return new CartItem(product, qty);
      v.quantity += qty;
      return v;
    });
  }

  public void updateItem(String productId, int qty) {
    if (items.containsKey(productId)) {
      if (qty <= 0) {
        items.remove(productId);
      } else {
        items.get(productId).quantity = qty;
      }
    }
  }

  public void removeItem(String productId) {
    items.remove(productId);
  }

  public Map<String, CartItem> getItems() {
    return items;
  }
}

