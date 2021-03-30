package edu.monash.fit2081.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char SQUARED = '²';
    private static final char NO_OPERATION = '?';

    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;
    public TextView interScreen;  // Intermediate result Screen
    private TextView resultScreen; // Result Screen


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Reference both TextViews
        interScreen =  findViewById(R.id.InterScreen);
        resultScreen =  findViewById(R.id.resultScreen);
        decimalFormat = new DecimalFormat("#.##########");
    }

    public void buttonZeroClick(View v) {
        interScreen.setText(interScreen.getText() + "0");
    }

    public void buttonOneClick(View v) {
        interScreen.setText(interScreen.getText() + "1");
    }

    public void buttonTwoClick(View v) {
        interScreen.setText(interScreen.getText() + "2");
    }

    public void buttonThreeClick(View v) {
        interScreen.setText(interScreen.getText() + "3");
    }

    public void buttonFourClick(View v) {
        interScreen.setText(interScreen.getText() + "4");
    }

    public void buttonFiveClick(View v) {
        interScreen.setText(interScreen.getText() + "5");
    }

    public void buttonSixClick(View v) {
        interScreen.setText(interScreen.getText() + "6");
    }

    public void buttonSevenClick(View v) {
        interScreen.setText(interScreen.getText() + "7");
    }

    public void buttonEightClick(View v) {
        interScreen.setText(interScreen.getText() + "8");
    }

    public void buttonNineClick(View v) {
        interScreen.setText(interScreen.getText() + "9");
    }

    public void buttonSquared(View v) {
        if (interScreen.getText().toString().equals("")){
            showToast("Invalid Key");
        } else {
            valueOne = Double.parseDouble(interScreen.getText().toString());
            valueOne = valueOne*valueOne;
            // interScreen.getText().toString() + "²" + " = " +
            resultScreen.setText(decimalFormat.format(valueOne));
            interScreen.setText("");
            valueOne = Double.NaN;
        }
    }

    public void buttonAdditionClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = ADDITION;
            resultScreen.setText(decimalFormat.format(valueOne) + "+");
            interScreen.setText("");
        }
    }

    public void buttonSubtractionClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = SUBTRACTION;
            resultScreen.setText(decimalFormat.format(valueOne) + "-");
            interScreen.setText("");
        }
    }

    public void buttonMultiplicationClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = MULTIPLICATION;
            resultScreen.setText(decimalFormat.format(valueOne) + "*");
            interScreen.setText("");
        }
    }

    public void buttonDivisionClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = DIVISION;
            resultScreen.setText(decimalFormat.format(valueOne) + "/");
            interScreen.setText("");
        }
    }

    public void buttonEqualClick(View v) {

        /*
        * Call ComputeCalculation method
        * Update the result TextView by adding the '=' char and result of operation
        * Reset valueOne
        * Set CURRENT_ACTION to NO_OPERATION
        * */
        computeCalculation();
        String currInter = interScreen.getText().toString();
        int i = 0;
        if (currInter != "") {
            i = Integer.parseInt(currInter);
        }

        String resStr = resultScreen.getText().toString();
        int currRes = 0;
        int result = i;
        if (resStr != ""){
            currRes = Integer.parseInt(resStr.substring(0, resStr.length()-1));

            String operation = resStr.substring(resStr.length()-1);

            switch(operation) {
                case "+":
                    CURRENT_ACTION = ADDITION;
                    resultScreen.setText(decimalFormat.format(valueOne-valueTwo) + "+" + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                    interScreen.setText("");
                    break;
                case "/":
                    CURRENT_ACTION = DIVISION;
                    resultScreen.setText(decimalFormat.format(valueOne*valueTwo) + "/" + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                    interScreen.setText("");
                    break;
                case "*":
                    CURRENT_ACTION = MULTIPLICATION;
                    resultScreen.setText(decimalFormat.format(valueOne/valueTwo) + "*" + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                    interScreen.setText("");
                    break;
                case "-":
                    CURRENT_ACTION = SUBTRACTION;
                    resultScreen.setText(decimalFormat.format(valueOne+valueTwo) + "+" + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                    interScreen.setText("");
                    break;
                case "²":
                    CURRENT_ACTION = SQUARED;
                    resultScreen.setText(decimalFormat.format(valueOne) + "²" + " = " + decimalFormat.format(valueOne));
                    interScreen.setText("");
                    break;
                case "":
                    result = i;
                    break;
            }
        }

//        String displayRes = resStr + currInter + " = " + String.valueOf(result);
//        resultScreen.setText(displayRes);
//        interScreen.setText("");
    }

    public void buttonDecimalClick(View v) {
        String currInter = interScreen.getText().toString();
        int i = 0;
        if (currInter != "") {
            i = Integer.parseInt(currInter);
        }

        String resStr = resultScreen.getText().toString();
        String result = currInter;
        if (currInter.substring(currInter.length() - 1) != ".") {
            result = String.valueOf(currInter) + ".";
        }
        interScreen.setText(result);

    }

    public void buttonClearClick(View v) {
        /*
        * if the intermediate TextView has text then
        *       delete the last character
        * else
              * reset valueOne, valueTwo, the content of result TextView,
              * and the content of intermediate TextView
        * */
        valueOne = 0;
        valueTwo = 0;
        resultScreen.setText("");
        interScreen.setText("");
    }

    private void computeCalculation() {

        if (!Double.isNaN(valueOne)) {
            String valueTwoString = interScreen.getText().toString();
            if (!valueTwoString.equals("")) {
                valueTwo = Double.parseDouble(valueTwoString);
                interScreen.setText(null);
                if (CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if (CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if (CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if (CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;
                else if (CURRENT_ACTION == SQUARED)
                    valueOne = this.valueOne * this.valueOne;
            }
        } else {
            try {
                valueOne = Double.parseDouble(interScreen.getText().toString());
            } catch (Exception e) {
            }

        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
