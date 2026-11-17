package com.pingidentity.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private UUID id;
  private String name;
  private int quantity;
  private String address;

}
