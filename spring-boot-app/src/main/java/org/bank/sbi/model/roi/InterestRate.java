package org.bank.sbi.model.roi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "INTEREST_RATE")
@EntityListeners(AuditingEntityListener.class)
public class InterestRate implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIMARY_KEY_GEN")
    @SequenceGenerator(name = "PRIMARY_KEY_GEN", sequenceName = "PRIMARY_KEY_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "INTEREST_RATE_ID")
    private Long interestRateID;

    @Column(name = "INTEREST_RATE")
    private String interestRate;

    @Column(name = "MONTHS")
    private String months;

    @Column(name = "YEARS")
    private String years;

    @Column(name = "DAYS")
    private String days;

    @Column(name = "XML")
    private byte[] xml;

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
