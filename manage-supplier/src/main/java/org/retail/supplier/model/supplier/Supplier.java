package org.retail.supplier.model.supplier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SUPPLIER")
@AccessType(Type.PROPERTY)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PK_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PK_GEN", sequenceName = "PK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "SUPPLIER_ID")
    private Long supplierID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PIN_CODE")
    private Integer pinCode;

    @Column(name = "STATE_CITY_ID")
    private Long stateCityID;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PRODUCT_ID")
    private Long productID;

    @Column(name = "QUANTITY_IN_STOCK")
    private Integer qtyInStock;

    @Column(name = "STATUS")
    private String status;

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
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_MODIFIED_DATE", updatable = false)
    @DateTimeFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date lastModifiedDate;

    @Column(name = "VERSION", updatable = false)
    private Integer version;

}
