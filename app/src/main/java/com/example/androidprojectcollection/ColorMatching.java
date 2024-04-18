package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ColorMatching extends AppCompatActivity {
    Button btnReturn, btnAutoWin;
    final int[] colors = {Color.BLUE, Color.RED, Color.GREEN};
    Button[][] buttons;
    int[][] btn_colors = new int[3][3]; // elements kay index sa colors
    boolean isWin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matching);

        buttons = new Button[][]{
                {findViewById(R.id.btn1), findViewById(R.id.btn2), findViewById(R.id.btn3)},
                {findViewById(R.id.btn4), findViewById(R.id.btn5), findViewById(R.id.btn6)},
                {findViewById(R.id.btn7), findViewById(R.id.btn8), findViewById(R.id.btn9)}
        };

        // adding onclick listeners
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(e->{
            startMatch();
        });

        btnAutoWin = findViewById(R.id.btnAutoWin);
        btnAutoWin.setOnClickListener(e -> {
            Random r = new Random();
            int color_index = r.nextInt(3);

            for (int i = 0; i < 3; i++){
                for (int j= 0; j < 3; j++){
                    btn_colors[i][j] = color_index;
                }
            }

            updateButtonColors();
        });

        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int row = i, col = j;
                buttons[i][j].setOnClickListener(e->{
                    if (!isWin){
                        changeButtonColorValue(row-1,  col); // change color of upper button
                        changeButtonColorValue(row+1, col); // change color of lower button
                        changeButtonColorValue(row, col-1); // change color of right button
                        changeButtonColorValue(row, col+1); // change color of this button

                        updateButtonColors();
                    }
                });
            }
        }

        startMatch();
    }

    private void startMatch(){
        isWin = false;

        randomizeColors();
        updateButtonColors();
    }

    private void randomizeColors() {
        Random r = new Random();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                btn_colors[i][j] = r.nextInt(3);
            }
        }
    }

    private void updateButtonColors() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int color = colors[btn_colors[i][j]];
                buttons[i][j].setBackgroundColor(color);
            }
        }

        if (checkWin()){
            Toast wintoast = Toast.makeText(this, "Colors MATCHED !! YOU WON!!", Toast.LENGTH_SHORT);
            wintoast.show();
            isWin = true;
        }
    }

    private void changeButtonColorValue(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2){
            return;
        }

        btn_colors[row][col] = (btn_colors[row][col] + 1) % 3; // change color value to next color in the color array
    }

    private boolean checkWin(){
        int color_to_compare = btn_colors[0][0];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (btn_colors[i][j] != color_to_compare){
                    return false; // colors not matching for all buttons
                }
            }
        }

        return true;
    }
}