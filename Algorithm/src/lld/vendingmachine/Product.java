package lld.vendingmachine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

  private final String id;
  private final String name;
  private final int price;
}
