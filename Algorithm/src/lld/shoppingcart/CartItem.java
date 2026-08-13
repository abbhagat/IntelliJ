package lld.shoppingcart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {

  private Product product;
  private int quantity;

  public double getTotalPrice() {
    return product.price() * quantity;
  }

  public String toString() {
    return product.name() + "\t" + quantity;
  }

}
