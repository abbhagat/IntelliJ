package lld.shoppingcart;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ShoppingCart {

  private String userId;
  private final Map<String, CartItem> cartItemMap;

  public ShoppingCart(String userId) {
    this.userId = userId;
    cartItemMap = new ConcurrentHashMap<>();
  }

  public void addItem(Product product, int qty) {
    CartItem cartItem = cartItemMap.computeIfAbsent(
        product.getProductId(),
        productId -> new CartItem(product, 0)
    );
    cartItem.setQuantity(cartItem.getQuantity() + qty);
  }

  public void addItems(Product product, int qty) {
    CartItem cartItems = cartItemMap.compute(product.getProductId(), (productId, cartItem) -> {
      if (cartItem == null) {
        return new CartItem(product, qty);
      }
      cartItem.setQuantity(cartItem.getQuantity() + qty);
      return cartItem;
    });
  }

  public void updateItem(String productId, int qty) {
    cartItemMap.computeIfPresent(productId, (id, cartItem) -> {
      if (qty <= 0) {
        return null; // Returning null inside computeIfPresent() tells Java to remove that entry from the map
      }
      cartItem.setQuantity(qty);
      return cartItem;
    });
  }

  public void removeItem(String productId) {
    cartItemMap.remove(productId);
  }

}
