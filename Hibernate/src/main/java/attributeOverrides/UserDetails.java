package attributeOverrides;

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
    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "USER_NAME")
    private String userName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "HOME_PINCODE"))
    }
    )
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

}
