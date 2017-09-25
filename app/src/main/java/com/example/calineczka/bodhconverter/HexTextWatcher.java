package com.example.calineczka.bodhconverter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;


class HexTextWatcher implements TextWatcher {
    private ITextWatcher watcher;
    private String binaryString;
    private String hexString;
    private String octalString;
    private String decimalString;
    private int hexNumberInDec;

    HexTextWatcher(ITextWatcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!isInputEmpty(s)) {
            hexString = s.toString();
            convertHex(hexString);
            decimalString = String.valueOf(hexNumberInDec);

        }
        else {
            decimalString = "";
            binaryString = "";
            octalString = "";
        }
        watcher.updateBinaryValue(binaryString);
        watcher.updateOctalValue(octalString);
        watcher.updateDecimalValue(decimalString);

    }
    public void afterTextChanged(Editable editable) {
    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length()==0;
    }


    private void convertHex(String hexString){
        try {
            hexNumberInDec = Integer.parseInt(hexString,16);
            binaryString = Integer.toBinaryString(hexNumberInDec);
            octalString = Integer.toOctalString(hexNumberInDec);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
