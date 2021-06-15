package org.bank.sbi.editor;

import java.beans.PropertyEditorSupport;

public class MICRCodeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String micrCode) throws IllegalArgumentException {
        micrCode = micrCode.contains("MICR") ? micrCode : "MICR-" + micrCode;
        setValue(micrCode);
    }
}
