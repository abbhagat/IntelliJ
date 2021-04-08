package singleTableStrategy;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

    private String steeringWheel;
}
