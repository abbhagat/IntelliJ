package com.pingidentity.test;

import lombok.*;

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
