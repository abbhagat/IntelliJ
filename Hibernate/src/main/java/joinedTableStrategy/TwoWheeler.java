package joinedTableStrategy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TwoWheeler extends Vehicle {
    private String steeringHandle;
}
