package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {

  private String vehicleNumber;
  private VehicleType type;

  @Override
  public String toString() {
    return vehicleNumber + "\t" + type.name();
  }
}
