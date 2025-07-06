package org.retail.product.model.uom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Id;
import jakarta.persistence.Version;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UOM")
@EntityListeners(AuditingEntityListener.class)
@AccessType(Type.PROPERTY)
public class Uom implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PK_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PK_GEN", sequenceName = "PK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "UOM_ID")
    private Long uomID;

    @Column(name = "UNIT_OF_MEASURE", nullable = false)
    private String uom;

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

    @Version
    @Column(name = "VERSION")
    private Integer version;

}
