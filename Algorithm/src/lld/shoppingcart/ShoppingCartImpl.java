package lld.shoppingcart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCartImpl implements IShoppingCart {

  private final Map<String, ShoppingCart> userToCartMap = new ConcurrentHashMap<>();

  @Override
  public ShoppingCart get(String userId) {
    ShoppingCart shoppingCart = userToCartMap.get(userId);
    if (shoppingCart == null) {
      shoppingCart = new ShoppingCart(userId);
      userToCartMap.put(userId, shoppingCart);
    }
    return shoppingCart;
  }

  @Override
  public void save(ShoppingCart shoppingCart) {
    userToCartMap.put(shoppingCart.getUserId(), shoppingCart);
  }
}
