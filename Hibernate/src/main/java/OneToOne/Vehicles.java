package OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VEHICLES")
public class Vehicles {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "VEHICLE_ID")
  private int vehicleID;

  @Column(name = "VEHICLE_NAME", nullable = false)
  private String vehicleName;

}
