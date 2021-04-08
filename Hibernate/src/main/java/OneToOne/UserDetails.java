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
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicles vehicles;

}
