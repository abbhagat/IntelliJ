package callingProcedure;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USER_DETAILS")
@NamedNativeQueries(
        @NamedNativeQuery(name = "userDetailsProcedure", query = "CALL PROCEDURE_NAME(:userdId,:userName)", resultClass = UserDetails.class)
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String name;

}
