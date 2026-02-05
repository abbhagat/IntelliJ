package lld.shoppingcart;

public interface CartRepository {

  ShoppingCart getCart(String userId);

  void saveCart(ShoppingCart cart);
}
