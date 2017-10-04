package com.example.calineczka.bodhconverter;

import android.text.Editable;
import android.text.TextWatcher;


class OctTextWatcher implements TextWatcher {
    private ITextWatcher watcher;
    private String decimalString;
    private String binaryString;
    private String hexString;

    OctTextWatcher(ITextWatcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!isInputEmpty(s.toString())) {
            String octalString = s.toString();
            convertOctal(octalString);
        } else {
            binaryString = "";
            hexString = "";
            decimalString = "";
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        watcher.updateDecimalValue(decimalString);
        watcher.updateBinaryValue(binaryString);
        watcher.updateHexValue(hexString);
    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length() == 0;
    }

    private void convertOctal(String octalString) {
        try {
            int octNumberInDec = Integer.parseInt(octalString, 8);
            binaryString = Integer.toBinaryString(octNumberInDec);
            hexString = Integer.toHexString(octNumberInDec);
            decimalString = (String.valueOf(octNumberInDec));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
