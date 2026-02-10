package lld.shoppingcart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {

  Product product;
  int quantity;

  public double getTotalPrice() {
    return product.getPrice() * quantity;
  }
}
