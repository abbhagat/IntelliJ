package tablePerClassStrategy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FourWheeler extends Vehicle {
    private String steeringWheel;
}
