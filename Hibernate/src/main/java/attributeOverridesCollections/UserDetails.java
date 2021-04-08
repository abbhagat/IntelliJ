package attributeOverridesCollections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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

    @Column(name = "USER_NAME")
    private String userName;

    @GenericGenerator(name = "native-gen", strategy = "native")
    @CollectionId(generator = "native-gen", type = @Type(type = "long"), columns = {@Column(name = "ADDRESS_ID")})
    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name = "USER_ID"))
    private Collection<Address> addressCollection = new ArrayList<>();

}
