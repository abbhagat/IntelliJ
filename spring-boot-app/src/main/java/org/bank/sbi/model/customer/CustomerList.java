package org.bank.sbi.model.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerList {

    private List<Customer> customerList;

    public CustomerList() {
        customerList = new ArrayList<>();
    }
}
