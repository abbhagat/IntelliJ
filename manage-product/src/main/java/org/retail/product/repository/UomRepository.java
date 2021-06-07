package org.retail.product.repository;

import org.retail.product.model.uom.Uom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomRepository extends JpaRepository<Uom, Long> {
}
