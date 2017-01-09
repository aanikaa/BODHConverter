package com.example.calineczka.bodhconverter;


import android.content.Context;
import android.widget.Toast;

class DecTextWatcher extends MyTextWatcher {
    private Context context;

    DecTextWatcher(Context context) {
        this.context = context;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!isInputEmpty(s)) {
            decimalString = s.toString();
            convertDecimal(decimalString);

            binTextView.setText(binaryString);
            octTextView.setText(octalString);
            hexTextView.setText(hexString);
        }
        else {
            octTextView.setText("");
            binTextView.setText("");
            hexTextView.setText("");
        }

    }

    private void convertDecimal(String decimalString){
        try {
            decimalNumber = Integer.parseInt(decimalString);
            binaryString = Integer.toBinaryString(decimalNumber);
            octalString = Integer.toOctalString(decimalNumber);
            hexString = Integer.toHexString(decimalNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }
}
