package org.retail.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Version;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ORDERS",uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL")
})
@AccessType(Type.PROPERTY)
@EntityListeners(AuditingEntityListener.class)
// @DynamicUpdate - Mean the update sql statement is generated at runtime and contains only those columns whose values have changed.
@DynamicUpdate(value=true)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PK_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PK_GEN", sequenceName = "PK_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "ORDER_ID")
    private Long orderID;

    @Column(name = "ORDER_NUM")
    private String orderNum;

    @Column(name = "ORDER_TYPE")
    private String orderType;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL",unique = true)
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;

    @Column(name = "BILLING_STATE_CITY_ID")
    private Long billingStateCityID;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "SHIPPING_STATE_CITY_ID")
    private Long shippingStateCityID;

    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date orderDate;

    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date deliveryDate;

    @Column(name = "BILL_AMOUNT")
    private BigDecimal billAmount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<OrderItems> orderItems = new ArrayList<>();

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
    @Version  // @Version - Hibernate framework will check the version of the record before updating it.
    private Integer version;
}
