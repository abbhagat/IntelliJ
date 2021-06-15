package org.bank.sbi.repository;

import org.bank.sbi.model.statecity.StateCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateCityDAO extends JpaRepository<StateCity, Long> {

}
