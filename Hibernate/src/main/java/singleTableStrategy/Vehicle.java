package singleTableStrategy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VECHILE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}

/**
 * Table Generated
 * <p>
 * ID   dtype         Name      steeringHandle    steeringWheel
 * 1   Vehicle       Car         null               null
 * 2   TwoWheeler    Bike        BikeSteering
 * 3   FourWheeler   Porsche     null               PorscheSteering
 * <p>
 * <p>
 * ID   VECHILE_TYPE  Name      steeringHandle    steeringWheel
 * 1   Vehicle       Car         null               null
 * 2   Bike          Bike        BikeSteering
 * 3   Car           Porsche     null               PorscheSteering
 */
