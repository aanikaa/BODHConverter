package com.example.calineczka.bodhconverter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;


class BinTextWatcher implements TextWatcher {

    private ITextWatcher watcher;
    private String binaryString;
    private String decimalString;
    private int binaryNumberInDec;
    private String octalString;
    private String hexString;

    BinTextWatcher(ITextWatcher watcher) {
        this.watcher = watcher;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!isInputEmpty(s)) {
            binaryString = s.toString();
            convertBinary(binaryString);
            decimalString = String.valueOf(binaryNumberInDec);
        } else {
            decimalString = "";
            octalString = "";
            hexString = "";
        }
        watcher.updateOctalValue(octalString);
        watcher.updateDecimalValue(decimalString);
        watcher.updateHexValue(hexString);


    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length() == 0;
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void convertBinary(String binaryString) {
        try {
            binaryNumberInDec = Integer.parseInt(binaryString, 2);
            octalString = Integer.toOctalString(binaryNumberInDec);
            hexString = Integer.toHexString(binaryNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
