package singleTableStrategy;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {

    private String steeringHandle;
}
