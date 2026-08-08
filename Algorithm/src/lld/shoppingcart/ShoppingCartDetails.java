package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCartDetails {

  private final Map<String, ShoppingCart> userToCartMap = new ConcurrentHashMap<>();

  public ShoppingCart get(String userId) {
    return userToCartMap.computeIfAbsent(userId, ShoppingCart::new);
  }

  public void put(ShoppingCart shoppingCart) {
    userToCartMap.put(shoppingCart.getUserId(), shoppingCart);
  }
}
