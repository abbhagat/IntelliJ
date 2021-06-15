package org.bank.sbi.repository;

import org.bank.sbi.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
