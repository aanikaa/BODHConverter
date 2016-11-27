package com.example.calineczka.bodhconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText binEditText;
    private EditText octEditText;
    private EditText decEditText;
    private EditText hexEditText;

    private TextView binTextView;
    private TextView octTextView;
    private TextView decTextView;
    private TextView hexTextView;

    private String binaryString;
    private String octalString;
    private String decimalString;
    private String hexString;

    private int binaryNumberInDec;
    private int octNumberInDec;
    private int decimalNumber;
    private int hexNumberInDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binEditText = (EditText) findViewById(R.id.BinEditText);
        octEditText = (EditText) findViewById(R.id.OctEditText);
        decEditText = (EditText) findViewById(R.id.DecEditText);
        hexEditText = (EditText) findViewById(R.id.HexEditText);

        binTextView = (TextView) findViewById(R.id.BinTextView);
        octTextView = (TextView) findViewById(R.id.OctTextView);
        decTextView = (TextView) findViewById(R.id.DecTextView);
        hexTextView = (TextView) findViewById(R.id.HexTextView);

        binEditText.addTextChangedListener(binTextChangedWatcher);
        octEditText.addTextChangedListener(octTextChangedWatcher);
        decEditText.addTextChangedListener(decTextChangedWatcher);
        hexEditText.addTextChangedListener(hexTextChangedWatcher);

    }

    private boolean isInputEmpty(CharSequence s) {
        return s.toString().length()==0;
    }

    public final TextWatcher binTextChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    private void convertBinary(String binaryString){
        try {
            binaryNumberInDec = Integer.parseInt(binaryString, 2);
            octalString = Integer.toOctalString(binaryNumberInDec);
            hexString = Integer.toHexString(binaryNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }

    private final TextWatcher octTextChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void convertOctal(String octalString){
        try {
            octNumberInDec = Integer.parseInt(octalString, 8);
            binaryString = Integer.toBinaryString(octNumberInDec);
            hexString = Integer.toHexString(octNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }

    private final TextWatcher decTextChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void convertDecimal(String decimalString){
        try {
            decimalNumber = Integer.parseInt(decimalString);
            binaryString = Integer.toBinaryString(decimalNumber);
            octalString = Integer.toOctalString(decimalNumber);
            hexString = Integer.toHexString(decimalNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }


    private final TextWatcher hexTextChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void convertHex(String hexString){
        try {
            hexNumberInDec = Integer.parseInt(hexString,16);
            binaryString = Integer.toBinaryString(hexNumberInDec);
            octalString = Integer.toOctalString(hexNumberInDec);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }

}
