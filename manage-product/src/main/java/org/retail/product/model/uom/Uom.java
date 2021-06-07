package org.retail.product.model.uom;

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
@Table(name = "UOM")
@EntityListeners(AuditingEntityListener.class)
@AccessType(Type.PROPERTY)
public class Uom implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PK_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PK_GEN", sequenceName = "PK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "UOM_ID")
    private Long uomID;

    @Column(name = "UNIT_OF_MEASURE", nullable = false, updatable = true)
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

    @Column(name = "VERSION", updatable = false)
    private Integer version;

    public void setVersion(Integer version) {
        this.version = null == version ? 1 : version + 1;
    }
}
