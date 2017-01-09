package com.example.calineczka.bodhconverter;

import android.content.Context;
import android.widget.Toast;


class HexTextWatcher extends MyTextWatcher {
    private Context context;

    HexTextWatcher(Context context) {
        this.context = context;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!isInputEmpty(s)) {
            hexString = s.toString();
            convertHex(hexString);

            decTextView.setText(String.valueOf(hexNumberInDec));
            octTextView.setText(octalString);
            binTextView.setText(binaryString);
        }
        else {
            decTextView.setText("");
            binTextView.setText("");
            octTextView.setText("");
        }
    }


private void convertHex(String hexString){
        try {
        hexNumberInDec = Integer.parseInt(hexString,16);
        binaryString = Integer.toBinaryString(hexNumberInDec);
        octalString = Integer.toOctalString(hexNumberInDec);
        } catch (NumberFormatException e) {
        e.printStackTrace();
        Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
        }

        }
}
