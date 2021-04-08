package joinedTableStrategy;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class TwoWheeler extends Vehicle {

    private String steeringHandle;
}
