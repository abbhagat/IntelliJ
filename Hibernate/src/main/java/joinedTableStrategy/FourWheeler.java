package joinedTableStrategy;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class FourWheeler extends Vehicle {

    private String steeringWheel;
}
