package org.retail.supplier.repository;

import org.retail.supplier.model.stateCity.StateCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateCityRepository extends JpaRepository<StateCity, Long> {
}
