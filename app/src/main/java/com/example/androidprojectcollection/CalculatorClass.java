package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorClass extends AppCompatActivity {
    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("=");
    }

    String calculateData(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }
        Stack<String> stackOp = new Stack<>();
        stackOp.push(finalData.get(0));

        for (int i = 1; i < finalData.size(); i++) {
            if (finalData.get(i).equals("+") || finalData.get(i).equals("-")) {
                stackOp.push(finalData.get(i));
            } else if (finalData.get(i).equals("*")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum * nextNum));
            } else if (finalData.get(i).equals("/")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum / nextNum));
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        double result = Double.parseDouble(stackOp.get(0));

        for (int i = 1; i < stackOp.size(); i += 2) {
            if (stackOp.get(i).equals("+")) {
                result += Double.parseDouble(stackOp.get(i + 1));
            } else {
                result -= Double.parseDouble(stackOp.get(i + 1));
            }
        }
        return String.valueOf(result);
    }
    String sequentialCalculate(String data){

        ArrayList<String> finalData = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }
        Stack<String> stackOp = new Stack<>();
        int start = 0;
        if(isOperator(finalData.get(0))){
            stackOp.push("0");
        } else {
            stackOp.push(finalData.get(0));
            start = 1;
        }

        for (int i = start; i < finalData.size(); i++) {
            if ( isOperator(finalData.get(i))) {
                if(finalData.get(i).equals("+")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum + nextNum));
                } else if (finalData.get(i).equals("-")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum - nextNum));
                } else if (finalData.get(i).equals("*")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum * nextNum));
                } else if (finalData.get(i).equals("/")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum / nextNum));
                }
            } else {
                stackOp.push(finalData.get(i));
            }
        }

        return stackOp.pop();
    }
}