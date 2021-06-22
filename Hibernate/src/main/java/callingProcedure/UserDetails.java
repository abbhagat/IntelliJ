package callingProcedure;

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
@NamedNativeQueries(
        @NamedNativeQuery(name = "userDetailsProcedure", query = "CALL PROCEDURE_NAME(:userId,:userName)", resultClass = UserDetails.class)
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String name;

}
