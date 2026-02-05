package lld.shoppingcart;

public class CartItem {
  Product product;
  int quantity;

  public CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public double getTotalPrice() {
    return product.price * quantity;
  }
}
