package com.example.calineczka.bodhconverter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

abstract class MyTextWatcher implements TextWatcher {
    TextView decTextView= MainActivity.getDecTextView();
    TextView octTextView= MainActivity.getOctTextView();
    TextView hexTextView=MainActivity.getHexTextView();
    TextView binTextView = MainActivity.getBinTextView();

    String binaryString;
    String hexString;
    String octalString;
    String decimalString;

    int binaryNumberInDec;
    int octNumberInDec;
    int decimalNumber;
    int hexNumberInDec;

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
     boolean isInputEmpty(CharSequence s) {
        return s.toString().length()==0;
    }

}
