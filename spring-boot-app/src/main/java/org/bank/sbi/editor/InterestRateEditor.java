package org.bank.sbi.editor;

import java.beans.PropertyEditorSupport;

public class InterestRateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String interestRate) throws IllegalArgumentException {
        if ("%".indexOf(interestRate) == -1) {
            interestRate = interestRate + "%";
        }
        setValue(interestRate);
    }
}
