package org.bank.sbi.model.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CUSTOMER")
@EntityListeners(AuditingEntityListener.class)
public class Customer implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PRIMARY_KEY_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRIMARY_KEY_GEN", sequenceName = "PRIMARY_KEY_SEQUENCE", initialValue = 1, allocationSize = 1)
    @Column(name = "CUSTOMER_ID", updatable = false, nullable = false)
    private Long customerID;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DOB")
    @PastOrPresent
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PHONE_NUMBER", length = 10)
    @NotBlank
    private String phoneNumber;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "PRESENT_ADDRESS")
    private String presentAddress;

    @Column(name = "PERMANENT_ADDRESS")
    private String permanentAddress;

    @Column(name = "STATE_CITY_ID")
    private Long stateCityID;

    @Column(name = "PIN_CODE")
    private String pinCode;

    @Column(name = "PROFILE_IMAGE")
    @Lob
    private byte[] profileImage;

    @Column(name = "SIGNATURE")
    @Lob
    private byte[] signature;

    @Column(name = "PAN_CARD")
    @Lob
    private byte[] panCard;

    @Column(name = "ID_PROOF")
    @Lob
    private byte[] idProof;

    @Column(name = "ADDRESS_PROOF")
    @Lob
    private byte[] addressProof;

    @Column(name = "XML")
    @Lob
    private byte[] xml;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_BY", nullable = false)
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date lastModifiedDate;

    @Column(name = "VERSION")
    private Integer version;

}
