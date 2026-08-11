package lld.shoppingcart;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {

  private String productId;
  private String name;
  private double price;

}
