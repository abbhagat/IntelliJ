package org.bank.sbi.editor;

import java.beans.PropertyEditorSupport;

public class IFSCCodeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String ifscCode) throws IllegalArgumentException {
        ifscCode = ifscCode.contains("IFSC") ? ifscCode : "IFSC-" + ifscCode;
        setValue(ifscCode);
    }
}
