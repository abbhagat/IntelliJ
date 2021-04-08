package joinedTableStrategy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}

/**
 * Table Generated
 * <p>
 * Vehicle
 * <p>
 * ID   Name
 * 1    Car
 * 2    Bike
 * 3    Porsche
 * <p>
 * TwoWheeler
 * <p>
 * ID   steeringHandle
 * 2     BikeSteering
 * <p>
 * FourWheeler
 * <p>
 * ID   steeringWheel
 * 3    PorscheSteering
 */
