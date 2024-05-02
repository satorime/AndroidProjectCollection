package com.example.androidprojectcollection;

import android.annotation.SuppressLint;
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
    private Button btPassingIntent;
    private Button btColorMatching;
    private Button btMenu;
    private Button btMaps;


    @SuppressLint("MissingInflatedId")
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

        btPassingIntent = findViewById(R.id.btnPassingIntent);
        btPassingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PassingIntentsExercise();
            }
        });

        btColorMatching = findViewById(R.id.btnMidterm);
        btColorMatching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorMatchingExercise();
            }
        });

        btMenu = findViewById(R.id.btnMenus);
        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuExercise();
            }
        });

        btMaps = findViewById(R.id.btnMaps);
        btMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapsExercise();
            }
        });
    }

    private void ColorMatchingExercise() {
        Intent intent = new Intent(MainActivity.this, ColorMatching.class);
        startActivity(intent);
    }

    private void PassingIntentsExercise() {
        Intent intent = new Intent(MainActivity.this, PassingIntentsExercise.class);
        startActivity(intent);
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

    private void MenuExercise() {
        Intent intent = new Intent(MainActivity.this, MenuExercise.class);
        startActivity(intent);
    }

    private void MapsExercise() {
        Intent intent = new Intent(MainActivity.this, MapsExercise.class);
        startActivity(intent);
    }
}