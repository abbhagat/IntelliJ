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
   {
     @NamedNativeQuery(name = "userDetailsProcedure", query = "CALL PROCEDURE_NAME(:userID,:userName)", resultClass = UserDetails.class)
   }
)
@NamedQueries(
   {
      @NamedQuery(name = "userDetails", query = "from UserDetails where userID = :userID and userName =:userName"),
      @NamedQuery(name = "userDetailsProcedure1", query = "CALL PROCEDURE_NAME(:userID,:userName)")
   }
)
@NamedStoredProcedureQuery(
        name="userDetails",
        procedureName="userDetails",
        resultClasses = { UserDetails.class },
        parameters={
                     @StoredProcedureParameter(name="userID",   type=String.class, mode=ParameterMode.IN),
                     @StoredProcedureParameter(name="userName", type=String.class, mode=ParameterMode.IN)
                   }
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

}


