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

/*   Table Generated

      Vehicle
        ID   Name
        1    Car
        2    Bike
        3    Porsche

     TwoWheeler
        ID    steeringHandle
        2     BikeSteering

     FourWheeler
       ID   steeringWheel
       3    PorscheSteering
 */
