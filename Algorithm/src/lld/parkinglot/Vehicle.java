package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {

  private String vehicleNumber;
  private VehicleType type;
}
