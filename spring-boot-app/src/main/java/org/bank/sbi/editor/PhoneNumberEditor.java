package org.bank.sbi.editor;

import java.beans.PropertyEditorSupport;

public class PhoneNumberEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String phoneNumber) {
        phoneNumber = phoneNumber.contains("+91-") ? phoneNumber : "+91-" + phoneNumber;
        setValue(phoneNumber);
    }
}
