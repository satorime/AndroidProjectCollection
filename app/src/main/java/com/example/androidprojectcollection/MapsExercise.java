package com.example.androidprojectcollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MapsExercise extends AppCompatActivity {
    private ImageButton imgbtnMagellan;
    private ImageButton imgbtnRoses;
    private ImageButton imgbtnSimala;
    private ImageButton imgbtnTops;
    private ImageButton imgbtnSanpedro;
    private TextView Title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        imgbtnMagellan = findViewById(R.id.imgbtnMagellan);
        imgbtnRoses = findViewById(R.id.imgbtnRoses);
        imgbtnSimala = findViewById(R.id.imgbtnSimala);
        imgbtnTops = findViewById(R.id.imgbtnTops);
        imgbtnSanpedro = findViewById(R.id.imgbtnSanpedro);
        Title = findViewById(R.id.Title);

        imgbtnMagellan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.mag);

                imgbtnRoses.setAlpha((float) 0.3);
                imgbtnSimala.setAlpha((float) 0.3);
                imgbtnTops.setAlpha((float) 0.3);
                imgbtnSanpedro.setAlpha((float) 0.3);
                imgbtnMagellan.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.2936, 123.9020"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[0]);
            }
        });

        imgbtnRoses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.rosesstreet);

                imgbtnMagellan.setAlpha((float) 0.3);
                imgbtnSimala.setAlpha((float) 0.3);
                imgbtnTops.setAlpha((float) 0.3);
                imgbtnSanpedro.setAlpha((float) 0.3);
                imgbtnRoses.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.2567, 123.9324"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[1]);
            }
        });

        imgbtnSimala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.simalastreet);

                imgbtnMagellan.setAlpha((float) 0.3);
                imgbtnRoses.setAlpha((float) 0.3);
                imgbtnTops.setAlpha((float) 0.3);
                imgbtnSanpedro.setAlpha((float) 0.3);
                imgbtnSimala.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.9796, 123.6134"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[2]);
            }
        });

        imgbtnTops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.topstreet);

                imgbtnMagellan.setAlpha((float) 0.3);
                imgbtnRoses.setAlpha((float) 0.3);
                imgbtnSimala.setAlpha((float) 0.3);
                imgbtnSanpedro.setAlpha((float) 0.3);
                imgbtnTops.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.3706, 123.8709"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[3]);
            }
        });

        imgbtnSanpedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.pedrostreet);

                imgbtnMagellan.setAlpha((float) 0.3);
                imgbtnRoses.setAlpha((float) 0.3);
                imgbtnSimala.setAlpha((float) 0.3);
                imgbtnTops.setAlpha((float) 0.3);
                imgbtnSanpedro.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.2925, 123.9056"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[4]);
            }
        });
    }
}