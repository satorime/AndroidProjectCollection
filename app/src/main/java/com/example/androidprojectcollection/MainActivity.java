package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btLayout;
    private Button btButton;
    private Button btCalcu;
    private Button btConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLayout  = findViewById(R.id.button);
        btLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutExercise();
            }
        });

        btButton = findViewById(R.id.button2);
        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonExercise();
            }
        });

        btCalcu = findViewById(R.id.button3);
        btCalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculatorExercise();
            }
        });

        btConnect = findViewById(R.id.button4);
        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect3Exercise();
            }
        });


    }

    public void LayoutExercise(){
        Intent intent = new Intent(MainActivity.this, LayoutExercise.class);
        startActivity(intent);
    }
    public void ButtonExercise(){
        Intent intent = new Intent(MainActivity.this, ButtonExercise.class);
        startActivity(intent);
    }

    public void CalculatorExercise(){
        Intent intent = new Intent(MainActivity.this, Calculator.class);
        startActivity(intent);
    }

    public void connect3Exercise(){
        Intent intent = new Intent(MainActivity.this, connect3.class);
        startActivity(intent);
    }
}