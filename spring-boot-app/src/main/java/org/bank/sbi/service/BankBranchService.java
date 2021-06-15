package org.bank.sbi.service;

import org.bank.sbi.model.bankbranch.BankBranch;
import org.bank.sbi.model.bankbranch.BankBranchList;
import org.bank.sbi.repository.BankBranchDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankBranchService {

    @Autowired
    private BankBranchDAO bankBranchDAO;

    public List<BankBranch> getAllBankBranch() {
        return bankBranchDAO.findAll();
    }

    public void saveBankBranch(BankBranchList bankBranchList) {
        bankBranchDAO.saveAll(bankBranchList.getBankBranchList());
    }

    public BankBranchList createBankBranch(BankBranchList bankBranchList) {
        bankBranchList.getBankBranchList().add(0, new BankBranch());
        return bankBranchList;
    }

    public List<BankBranch> searchBankBranch(BankBranch bankBranch) {
        return bankBranchDAO.findAll(Example.of(bankBranch));
    }

}
