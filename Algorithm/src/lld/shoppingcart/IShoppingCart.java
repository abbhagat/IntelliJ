package lld.shoppingcart;

public interface IShoppingCart {

  void addItem(Product product, int qty);
  void updateItem(String productId, int qty);
  void removeItem(String productId);
}
