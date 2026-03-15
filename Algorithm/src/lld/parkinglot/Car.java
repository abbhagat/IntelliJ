package lld.parkinglot;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Car extends Vehicle {

  public Car(String vehicleNumber, VehicleType type) {
    super(vehicleNumber, type);
  }

}
