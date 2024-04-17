package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        Button btClose = (Button) findViewById(R.id.button5);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ButtonExercise.this, ReturnButton.class);
                startActivity(intent);
            }
        });

        Button btToast = findViewById(R.id.button6);
        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this,"This is toast", Toast.LENGTH_LONG).show();
            }
        });

        Button btChangeBg = findViewById(R.id.button7);
        btChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }
        });

        Button btButtonChangeBg = findViewById(R.id.button10);
        btButtonChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btButtonChangeBg.setBackgroundColor(getResources().getColor(R.color.colorOffYellow));
                btButtonChangeBg.setTextColor(getResources().getColor(R.color.ColorOffBlack));
            }
        });

        Button btDisappear = findViewById(R.id.button11);
        btDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btDisappear.setVisibility(View.INVISIBLE);
                btDisappear.setClickable(false);
            }
        });
    }

    public void ReturnButton(){
        Intent intent = new Intent(ButtonExercise.this, ReturnButton.class);
        startActivity(intent);
    }
}