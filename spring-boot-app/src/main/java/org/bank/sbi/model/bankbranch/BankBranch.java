package org.bank.sbi.model.bankbranch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bank.sbi.validator.IsValidStatus;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BANK_BRANCH")
@EntityListeners(AuditingEntityListener.class)
public class BankBranch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PRIMARY_KEY_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRIMARY_KEY_GEN", sequenceName = "PRIMARY_KEY_SEQUENCE", allocationSize = 1, initialValue = 1)
    @Column(name = "BRANCH_ID")
    private Long branchID;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATE_CITY_ID")
    private Long stateCityID;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "MICR_CODE")
    private String micrCode;

    @Column(name = "BRANCH_MANAGER")
    private String branchManager;

    @Column(name = "STATUS")
    @IsValidStatus(listOfValidStatus = {"Active", "InActive", "NA"})
    private String status;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Temporal(TemporalType.DATE)
    @PastOrPresent
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @FutureOrPresent
    @Column(name = "DISABLE_DATE")
    private Date disableDate;

    @Column(name = "DESCRIPTION")
    private String description;

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
