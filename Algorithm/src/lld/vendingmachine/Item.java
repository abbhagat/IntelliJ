package lld.vendingmachine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

  private final Product product;
  private int quantity;

  public boolean isAvailable() {
    return quantity > 0;
  }

  public void reduceQuantity() {
    quantity--;
  }

}
