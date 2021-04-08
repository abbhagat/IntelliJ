package ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "vehicles")
    private List<UserDetails> userDetails = new ArrayList<>();

}
