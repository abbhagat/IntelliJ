package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCartRepository implements CartRepository {

  private final Map<String, ShoppingCart> store = new ConcurrentHashMap<>();

  @Override
  public ShoppingCart getCart(String userId) {
    return store.computeIfAbsent(userId, ShoppingCart::new);
  }

  @Override
  public void saveCart(ShoppingCart cart) {
    store.put(cart.getUserId(), cart);
  }
}
