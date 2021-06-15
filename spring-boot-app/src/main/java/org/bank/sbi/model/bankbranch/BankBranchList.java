package org.bank.sbi.model.bankbranch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BankBranchList implements Serializable {

    private static final Long serialversionUID = 1L;

    private List<BankBranch> bankBranchList;

    public BankBranchList() {
        this.bankBranchList = new ArrayList<>();
    }

}
