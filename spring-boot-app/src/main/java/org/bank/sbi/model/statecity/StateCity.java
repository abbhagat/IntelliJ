package org.bank.sbi.model.statecity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "STATE_CITY")
@EntityListeners(AuditingEntityListener.class)
//@JsonPropertyOrder({"stateCityID", "state", "city_name", "xml"}) // Order in which the JSON Response is created
//@JsonIgnoreProperties({"stateCityID"}) // stateCityID will no be a part of JSON Response Body
//@JsonInclude(JsonInclude.Include.NON_NULL) null values will not be included in JSON Response
public class StateCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIMARY_KEY_GEN")
    @SequenceGenerator(name = "PRIMARY_KEY_GEN", sequenceName = "PRIMARY_KEY_SEQUENCE", initialValue = 1, allocationSize = 1)
    @Column(name = "STATE_CITY_ID")
    private Long stateCityID;

    @Column(name = "STATE")
    @NotBlank
    private String state;

    //@JsonProperty("city_name")
    @Column(name = "CITY")
    @NotBlank
    private String city;

    @Column(name = "XML")
    private byte[] xml;

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY", updatable = false)
    private String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", updatable = false)
    @DateTimeFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date lastModifiedDate;

    @Column(name = "VERSION", updatable = false)
    private Integer version;

}
