package com.example.calineczka.bodhconverter;

import android.content.Context;
import android.widget.Toast;


class OctTextWatcher extends MyTextWatcher {
    private Context context;

    OctTextWatcher(Context context) {
        this.context = context;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!isInputEmpty(s)) {
            octalString = s.toString();
            convertOctal(octalString);

            decTextView.setText(String.valueOf(octNumberInDec));
            binTextView.setText(binaryString);
            hexTextView.setText(hexString);
        }
        else {
            decTextView.setText("");
            binTextView.setText("");
            hexTextView.setText("");
        }
    }

    private void convertOctal(String octalString){
        try {
            octNumberInDec = Integer.parseInt(octalString, 8);
            binaryString = Integer.toBinaryString(octNumberInDec);
            hexString = Integer.toHexString(octNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }
}
