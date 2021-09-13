package secondLevelCache;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NamedNativeQueries(
        {
                @NamedNativeQuery(name = "ALL_USERS", query = "SELECT * FROM USER_DETAILS", resultClass = UserDetails.class)
        }
)
@NamedQueries(
        {
                @NamedQuery(name = "ALL_USERS1", query = "from UserDetails")
        }
)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@DynamicUpdate(value=true) // Mean the update sql statement is generated at runtime and contains only those columns whose values have changed.
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "USER_NAME")
    private String userName;

}
