package com.example.calineczka.bodhconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText binEditText;
    EditText octEditText;
    EditText decEditText;
    EditText hexEditText;

    static TextView binTextView;
    static TextView octTextView;
    static TextView decTextView;
    static TextView hexTextView;


    MyTextWatcher textWatcher;



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

        binEditText.addTextChangedListener(textWatcher = new BinTextWatcher(MainActivity.this));
        octEditText.addTextChangedListener(textWatcher = new OctTextWatcher(MainActivity.this));
        decEditText.addTextChangedListener(textWatcher = new DecTextWatcher(MainActivity.this));
        hexEditText.addTextChangedListener(textWatcher = new HexTextWatcher(MainActivity.this));

    }


    public static TextView getDecTextView() {
        return decTextView;
    }

    public static TextView getOctTextView() {
        return octTextView;
    }

    public static TextView getBinTextView(){
        return binTextView;
    }

    public static TextView getHexTextView() {
        return hexTextView;
    }

}
