package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCartDetails {

  private final Map<String, ShoppingCart> userToCartMap = new ConcurrentHashMap<>();

  public ShoppingCart getShoppingCart(String userId) {
    ShoppingCart shoppingCart = userToCartMap.get(userId);
    if (shoppingCart == null) {
      shoppingCart = new ShoppingCart(userId);
      userToCartMap.put(userId, shoppingCart);
    }
    return shoppingCart;
  }

  public ShoppingCart get(String userId) {
    return userToCartMap.computeIfAbsent(userId, ShoppingCart::new);
    // return userToCartMap.computeIfAbsent(userId, id -> new ShoppingCart(id));
  }

  public void put(ShoppingCart shoppingCart) {
    userToCartMap.put(shoppingCart.getUserId(), shoppingCart);
  }
}
