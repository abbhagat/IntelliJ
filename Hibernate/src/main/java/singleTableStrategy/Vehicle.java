package singleTableStrategy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}

/*
 * Table Generated

 * ID   dtype         Name      steeringHandle    steeringWheel
 * 1   Vehicle       Car         null               null
 * 2   TwoWheeler    Bike        BikeSteering       null
 * 3   FourWheeler   Porsche     null               PorscheSteering
 * ******************************************************************
 * ID   VEHICLE_TYPE  Name      steeringHandle    steeringWheel
 * 1   Vehicle       Car         null               null
 * 2   Bike          Bike        BikeSteering       null
 * 3   Car           Porsche     null               PorscheSteering
 */
