package attributeOverrides;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "STREET_NAME")
    String street;
    @Column(name = "CITY_NAME")
    private String city;
    @Column(name = "STATE_NAME")
    private String state;
    @Column(name = "PIN_CODE")
    private String pinCode;
}
