package com.example.calineczka.bodhconverter;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

class DecTextWatcher implements TextWatcher {
    private ITextWatcher watcher;
    private String decimalString;
    private String binaryString;
    private String octalString;
    private String hexString;
    private int decimalNumber;

    DecTextWatcher(ITextWatcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!isInputEmpty(s)) {
            decimalString = s.toString();
            convertDecimal(decimalString);
        }
        else {
            octalString = "";
            binaryString = "";
            hexString = "";
        }
        watcher.updateBinaryValue(binaryString);
        watcher.updateOctalValue(octalString);
        watcher.updateHexValue(hexString);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length()==0;
    }

    private void convertDecimal(String decimalString){
        try {
            decimalNumber = Integer.parseInt(decimalString);
            binaryString = Integer.toBinaryString(decimalNumber);
            octalString = Integer.toOctalString(decimalNumber);
            hexString = Integer.toHexString(decimalNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
