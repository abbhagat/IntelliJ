package lld.shoppingcart;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Product {

  private String productId;
  private String name;
  private double price;

  public String toString() {
    return name;
  }

}
