package com.example.calineczka.bodhconverter;

import android.text.Editable;
import android.text.TextWatcher;


class HexTextWatcher implements TextWatcher {
    private ITextWatcher watcher;
    private String binaryString;
    private String octalString;
    private String decimalString;

    HexTextWatcher(ITextWatcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!isInputEmpty(s)) {
            String hexString = s.toString();
            convertHex(hexString);
        } else {
            decimalString = "";
            binaryString = "";
            octalString = "";
        }
    }

    public void afterTextChanged(Editable editable) {
        watcher.updateBinaryValue(binaryString);
        watcher.updateOctalValue(octalString);
        watcher.updateDecimalValue(decimalString);
    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length() == 0;
    }


    private void convertHex(String hexString) {
        try {
            int hexNumberInDec = Integer.parseInt(hexString, 16);
            binaryString = Integer.toBinaryString(hexNumberInDec);
            octalString = Integer.toOctalString(hexNumberInDec);
            decimalString = String.valueOf(hexNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
