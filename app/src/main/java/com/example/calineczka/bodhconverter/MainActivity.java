package com.example.calineczka.bodhconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;


public class MainActivity extends AppCompatActivity implements ITextWatcher {
    @BindView(R.id.BinEditText) EditText binEditText;
    @BindView(R.id.OctEditText) EditText octEditText;
    @BindView(R.id.DecEditText) EditText decEditText;
    @BindView(R.id.HexEditText) EditText hexEditText;

    @BindView(R.id.BinTextView) TextView binTextView;
    @BindView(R.id.OctTextView) TextView octTextView;
    @BindView(R.id.DecTextView) TextView decTextView;
    @BindView(R.id.HexTextView) TextView hexTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        binEditText.addTextChangedListener(new BinTextWatcher(this));
        octEditText.addTextChangedListener(new OctTextWatcher(this));
        decEditText.addTextChangedListener(new DecTextWatcher(this));
        hexEditText.addTextChangedListener(new HexTextWatcher(this));
    }

    @OnFocusChange(R.id.BinEditText)
    void clearBinValue(){
        binTextView.setText("");
        clearAllPreviousInputs();
    }

    private void clearAllPreviousInputs() {
        binEditText.setText("");
        octEditText.setText("");
        decEditText.setText("");
        hexEditText.setText("");
    }

    @OnFocusChange(R.id.OctEditText)
    void clearOctValue(){
        octTextView.setText("");
        clearAllPreviousInputs();
    }
    @OnFocusChange(R.id.DecEditText)
    void clearDecValue(){
        decTextView.setText("");
        clearAllPreviousInputs();
    }
    @OnFocusChange(R.id.HexEditText)
    void clearHexValue(){
        hexTextView.setText("");
        clearAllPreviousInputs();
    }

    @Override
    public void updateBinaryValue(String binaryString) {
        binTextView.setText(binaryString);
    }

    @Override
    public void updateOctalValue(String octalString) {
        octTextView.setText(octalString);
    }

    @Override
    public void updateDecimalValue(String decimalString) {
        decTextView.setText(decimalString);
    }

    @Override
    public void updateHexValue(String hexString) {
        hexTextView.setText(hexString);
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
    }

}
