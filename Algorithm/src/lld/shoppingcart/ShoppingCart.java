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
    String productId = product.getProductId();
    CartItem cartItem = cartItemMap.get(productId);
    if (cartItem == null) {
      cartItem = new CartItem(product, qty);
      cartItemMap.put(productId, cartItem);
    } else {
      cartItem.setQuantity(cartItem.getQuantity() + qty);
    }
  }

  public void addItemss(Product product, int qty) {
    cartItemMap.compute(product.getProductId(), (productId, cartItem) -> {
      if (cartItem == null) {
        return new CartItem(product, qty);
      }
      cartItem.setQuantity(cartItem.getQuantity() + qty);
      return cartItem;
    });
  }

  public void updateItem(String productId, int qty) {
    if (cartItemMap.containsKey(productId)) {
      if (qty <= 0) {
        cartItemMap.remove(productId);
      } else {
        CartItem cartItem = cartItemMap.get(productId);
        cartItem.setQuantity(qty);
      }
    }
  }

  public void updateItems(String productId, int qty) {
    cartItemMap.computeIfPresent(productId, (id, item) -> {
      if (qty <= 0) {
        return null; // Removes the mapping
      }
      item.setQuantity(qty);
      return item;
    });
  }

  public void removeItem(String productId) {
    cartItemMap.remove(productId);
  }

}
