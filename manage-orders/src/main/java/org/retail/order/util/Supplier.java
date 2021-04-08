package org.retail.order.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Supplier {

    private Long supplierID;
    private String name;
    private String address;
    private Integer pinCode;
    private Long stateCityID;
    private String phoneNumber;
    private String email;
    private Long productID;
    private Integer qtyInStock;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private Integer version;
}
