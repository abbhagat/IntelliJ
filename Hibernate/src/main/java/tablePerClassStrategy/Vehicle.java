package tablePerClassStrategy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
 * <p>
 * TwoWheeler
 * <p>
 * ID   Name  steeringHandle
 * 2    Bike   BikeSteering
 * <p>
 * FourWheeler
 * <p>
 * ID   Name      steeringWheel
 * 3    Porsche   PorscheSteering
 */
