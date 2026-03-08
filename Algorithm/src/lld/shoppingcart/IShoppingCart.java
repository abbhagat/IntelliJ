package lld.shoppingcart;

public interface IShoppingCart {
  ShoppingCart get(String userId);
  void save(ShoppingCart cart);
}
