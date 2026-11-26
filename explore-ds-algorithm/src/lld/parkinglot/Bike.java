package lld.parkinglot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bike extends Vehicle {

  public Bike(String vehicleNumber, VehicleType type) {
    super(vehicleNumber, type);
  }

}
