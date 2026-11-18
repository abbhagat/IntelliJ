package lld.parkinglot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car extends Vehicle {

  public Car(String vehicleNumber, VehicleType type) {
    super(vehicleNumber, type);
  }

}
