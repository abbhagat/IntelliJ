package lld.shoppingcart;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ShoppingCart {

  String userId;
  private final Map<String, CartItem> cartItemMap = new ConcurrentHashMap<>();

  public ShoppingCart(String userId) {
    this.userId = userId;
  }

  public void addItem(Product product, int qty) {
    String productId = product.getProductId();
    CartItem cartItem = cartItemMap.get(productId);
    if (cartItem == null) {
      cartItem = new CartItem(product, qty);
      cartItemMap.put(productId, cartItem);
    } else {
      cartItem.setQuantity(cartItem.getQuantity() + qty);
    }
  }

  public void updateItem(String productId, int qty) {
    if (cartItemMap.containsKey(productId)) {
      if (qty <= 0) {
        cartItemMap.remove(productId);
      } else {
        cartItemMap.get(productId).setQuantity(qty);
      }
    }
  }

  public void removeItem(String productId) {
    cartItemMap.remove(productId);
  }

}
