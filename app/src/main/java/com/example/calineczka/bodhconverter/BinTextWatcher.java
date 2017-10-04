package com.example.calineczka.bodhconverter;

import android.text.Editable;
import android.text.TextWatcher;


class BinTextWatcher implements TextWatcher {

    private ITextWatcher watcher;
    private String decimalString;
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
        String input = s.toString();
        if (!isInputEmpty(input)) {
            String binaryString = s.toString();
            convertBinary(binaryString);
        } else {
            octalString = "";
            decimalString = "";
            hexString = "";
        }
    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length() == 0;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        watcher.updateOctalValue(octalString);
        watcher.updateDecimalValue(decimalString);
        watcher.updateHexValue(hexString);
    }

    private void convertBinary(String binaryString) {
        try {
            int binaryNumberInDec = Integer.parseInt(binaryString, 2);
            octalString = Integer.toOctalString(binaryNumberInDec);
            hexString = Integer.toHexString(binaryNumberInDec);
            decimalString = String.valueOf(binaryNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            watcher.showErrorToast();
        }

    }
}
