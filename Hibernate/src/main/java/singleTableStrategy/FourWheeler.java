package singleTableStrategy;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Car")
@EqualsAndHashCode(callSuper = true)
public class FourWheeler extends Vehicle {
  private String steeringWheel;
}
