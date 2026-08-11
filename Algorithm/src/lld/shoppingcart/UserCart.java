package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserCart {

  private static final Map<String, ShoppingCart> userToCartMap = new ConcurrentHashMap<>();

  public static ShoppingCart get(String userId) {
    return userToCartMap.computeIfAbsent(userId, ShoppingCart::new);
  }

  public static void put(ShoppingCart shoppingCart) {
    userToCartMap.put(shoppingCart.getUserId(), shoppingCart);
  }
}
