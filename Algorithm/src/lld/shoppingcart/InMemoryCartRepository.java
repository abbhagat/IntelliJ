package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCartRepository implements CartRepository {

  private final Map<String, ShoppingCart> userToCartMap = new ConcurrentHashMap<>();

  @Override
  public ShoppingCart getCart(String userId) {
    ShoppingCart cart = userToCartMap.get(userId);
    if (cart == null) {
      cart = new ShoppingCart(userId);
      userToCartMap.put(userId, cart);
    }
    return cart;
  }

  @Override
  public void saveCart(ShoppingCart cart) {
    userToCartMap.put(cart.getUserId(), cart);
  }
}
