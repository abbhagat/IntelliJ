package OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_DETAILS")
public class UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private int userID;

  @Column(name = "USER_NAME", nullable = false)
  private String userName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails", fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  private List<Vehicles> vehicles = new ArrayList<>();

//    @OneToMany
//    @JoinTable(name = "USER_VEHICLE",joinColumns = @JoinColumn(name = "USER_ID"),inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
//    private List<Vehicles> vehicles = new ArrayList<>();

}
