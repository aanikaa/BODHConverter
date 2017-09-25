package com.example.calineczka.bodhconverter;


interface ITextWatcher {
    void updateBinaryValue(String binaryString);
    void updateOctalValue(String octalString);
    void updateDecimalValue(String decimalString);
    void updateHexValue(String hexString);
    void showErrorToast();
}
