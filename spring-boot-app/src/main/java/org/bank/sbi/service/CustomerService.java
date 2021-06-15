package org.bank.sbi.service;

import org.bank.sbi.model.customer.Customer;
import org.bank.sbi.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAllCustomer() {
        return customerDAO.findAll();
    }

    public Customer getCustomerByID(Long customerID) {
        return customerDAO.getOne(customerID);
    }

    public List<Customer> searchCustomer(Customer customer) {
        return customerDAO.findAll(Example.of(customer));
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void deleteCustomer(Long customerID) {
        customerDAO.deleteById(customerID);
    }

    public void deleteCustomer(Customer customer) {
        customerDAO.delete(customer);
    }
}

