package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends CalculatorClass implements View.OnClickListener {

private TextView solutionTv;
private TextView resultTv;

Button button0, button1,button2, button3,button4, button5,button6,button7,button8,button9,buttonPlus,buttonMinus,buttonMulti,buttonDiv,buttonDec,buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        ArrayList<Button>nums = new ArrayList<>();

        solutionTv = findViewById(R.id.solutionTv);
        resultTv = findViewById(R.id.resultTv);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti= findViewById(R.id.buttonMult);
        buttonDiv= findViewById(R.id.buttonDiv);

        buttonDec = findViewById(R.id.buttonDec);
        buttonEqual = findViewById(R.id.buttonEqual);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

        buttonDec.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }
     boolean op = false;
    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String seqGiven = solutionTv.getText().toString();

        if (buttonText.equals("=")) {
          if (isOperator(seqGiven.substring(seqGiven.length() - 1))) {
                seqGiven = seqGiven.substring(0, seqGiven.length() - 1) + "=";
           }
          seqGiven = calculateData(seqGiven);
          resultTv.setText(seqGiven);
        } else if (buttonText.equals(".")) {
            String last_num = "";
            for (int i = seqGiven.length() - 1; i >= 0; i--) {
                if (isOperator(String.valueOf(seqGiven.charAt(i)))) {
                    break;
                }
                last_num += seqGiven.charAt(i);
            }
            if (last_num.equals("")) {
                seqGiven += "0";
                seqGiven += buttonText;
            } else if (last_num.contains(".")) {
                if (last_num.charAt(0) == '.') {
                    seqGiven = seqGiven.substring(0, seqGiven.length() - 1);
                }
            } else {
                seqGiven += buttonText;
            }
            solutionTv.setText(seqGiven);
        } else {

            if (!seqGiven.isEmpty() && isOperator(String.valueOf(seqGiven.charAt(seqGiven.length() - 1))) && isOperator(buttonText)) {
                seqGiven = seqGiven.substring(0, seqGiven.length() - 1);
                op=true;
            }
            String tempo = seqGiven;
            seqGiven += buttonText;
            solutionTv.setText(seqGiven);
            if (isOperator(buttonText)) {
                resultTv.setText(sequentialCalculate(tempo));
            }
        }
    }
}
