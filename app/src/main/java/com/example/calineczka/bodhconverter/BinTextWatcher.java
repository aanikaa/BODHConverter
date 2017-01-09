package com.example.calineczka.bodhconverter;

import android.content.Context;
import android.widget.Toast;


class BinTextWatcher extends MyTextWatcher {

    private Context context;

    BinTextWatcher(Context context){
        this.context= context;
    }


    @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!isInputEmpty(s)) {
                binaryString = s.toString();
                convertBinary(binaryString);
                decTextView.setText(String.valueOf(binaryNumberInDec));
                octTextView.setText(octalString);
                hexTextView.setText(hexString);
            }
            else {
                decTextView.setText("");
                octTextView.setText("");
                hexTextView.setText("");
            }

        }
    private void convertBinary(String binaryString){
        try {
            binaryNumberInDec = Integer.parseInt(binaryString, 2);
            octalString = Integer.toOctalString(binaryNumberInDec);
            hexString = Integer.toHexString(binaryNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }
}
