package com.example.calineczka.bodhconverter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;


class OctTextWatcher implements TextWatcher {
    private ITextWatcher watcher;
    private String decimalString;
    private String octalString;
    private int octNumberInDec;
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
        if(!isInputEmpty(s)) {
            octalString = s.toString();
            convertOctal(octalString);

           decimalString =(String.valueOf(octNumberInDec));

        }
        else {
            decimalString = "";
            binaryString = "";
            hexString = "";
        }
        watcher.updateDecimalValue(decimalString);
        watcher.updateBinaryValue(binaryString);
        watcher.updateHexValue(hexString);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length()==0;
    }

    private void convertOctal(String octalString){
        try {
            octNumberInDec = Integer.parseInt(octalString, 8);
            binaryString = Integer.toBinaryString(octNumberInDec);
            hexString = Integer.toHexString(octNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
