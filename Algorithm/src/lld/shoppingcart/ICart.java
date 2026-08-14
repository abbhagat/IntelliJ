package lld.shoppingcart;

public interface ICart {

  void addItem(Product product, int qty);
  void updateItem(String productId, int qty);
  void removeItem(String productId);
}
