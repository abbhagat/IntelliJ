package org.bank.sbi.service;

import org.bank.sbi.model.roi.InterestRate;
import org.bank.sbi.repository.InterestRateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestRateService {

    @Autowired
    private InterestRateDAO interestRateDAO;

    public List<InterestRate> getAllInterestRate() {
        return interestRateDAO.findAll();
    }

    public void saveInterestRate(InterestRate interestRate){
        interestRateDAO.save(interestRate);
    }
}
