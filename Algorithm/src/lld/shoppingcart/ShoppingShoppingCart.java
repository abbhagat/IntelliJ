package lld.shoppingcart;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ShoppingShoppingCart implements IShoppingCart {

  private final Map<String, CartItem> cartItemMap;

  public ShoppingShoppingCart() {
    cartItemMap = new ConcurrentHashMap<>();
  }

  @Override
  public void addItem(Product product, int qty) {
    CartItem cartItem = cartItemMap.computeIfAbsent(product.id(), value -> new CartItem(product, 0));
    cartItem.setQuantity(cartItem.getQuantity() + qty);
  }

  @Override
  public void updateItem(String productId, int qty) {
    cartItemMap.computeIfPresent(productId, (id, cartItem) -> {
      if (qty <= 0) {
        return null; // Returning null inside computeIfPresent() tells Java to remove that entry from the map
      }
      cartItem.setQuantity(qty);
      return cartItem;
    });
  }

  @Override
  public void removeItem(String productId) {
    cartItemMap.remove(productId);
  }

  public String toString() {
    cartItemMap.values().forEach(System.out::println);
    return "";
  }

}
