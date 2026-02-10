package lld.parkinglot;

import lombok.Getter;

@Getter
public abstract class Vehicle {
  private String licenseNumber;
  private VehicleType type;
}
