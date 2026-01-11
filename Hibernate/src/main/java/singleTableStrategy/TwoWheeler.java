package singleTableStrategy;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Bike")
@EqualsAndHashCode(callSuper = true)
public class TwoWheeler extends Vehicle {
  private String steeringHandle;
}
