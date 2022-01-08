package org.bank.sbi.repository;

import org.bank.sbi.model.bankbranch.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchDAO extends JpaRepository<BankBranch, Long> {

}
