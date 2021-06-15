package org.bank.sbi.repository;

import org.bank.sbi.model.roi.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRateDAO extends JpaRepository<InterestRate, Long> {

}
