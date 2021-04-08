package tablePerClassStrategy;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class FourWheeler extends Vehicle {

    private String steeringWheel;
}
