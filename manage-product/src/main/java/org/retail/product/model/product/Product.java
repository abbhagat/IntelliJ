package org.retail.product.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_GEN")
    @SequenceGenerator(sequenceName = "PK_SEQ", name = "PK_GEN", initialValue = 1, allocationSize = 1)
    @Column(name = "PRODUCT_ID")
    private Long productID;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COST_PRICE")
    private String costPrice;

    @Column(name = "SELL_PRICE")
    private String sellPrice;

    @Column(name = "QUANTITY_AVAILABLE")
    private Integer quantityAvailable;

    @Column(name = "UOM_ID")
    private Integer uomID;

    @Column(name = "STATUS")
    private String status = "Y";

    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_MODIFIED_DATE")
    @DateTimeFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date lastModifiedDate;

    @Version
    @Column(name = "VERSION")
    private Integer version;

}
