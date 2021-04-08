package org.retail.order.model;

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
@AccessType(Type.PROPERTY)
@Table(name = "ORDER_ITEMS")
@EntityListeners(AuditingEntityListener.class)
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PK_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PK_GEN", sequenceName = "PK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemID;

//    @Column(name = "ORDER_ID",nullable = false)
//    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;

    @Column(name = "PRODUCT_ID")
    private Long productID;

    @Column(name = "SUPPLIER_ID")
    private Long supplierID;

    @Column(name = "QUANTITY")
    private int quantity;

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

}
