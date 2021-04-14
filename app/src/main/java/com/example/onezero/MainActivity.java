package com.example.onezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    private TextView textGrid, birtxt, ikkitxt, uchtxt, torttxtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textGrid = findViewById(R.id.textGrid);
        birtxt = findViewById(R.id.birtxt);
        ikkitxt = findViewById(R.id.ikkitxt);
        uchtxt = findViewById(R.id.uchtxt);
        torttxtx=findViewById(R.id.torttxtx);


        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finali = i;
            cardView.setOnClickListener(view -> {
                if (finali == 0) {
                    Intent intent = new Intent(MainActivity.this, ActivityOne.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");
                } else if (finali == 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");

                } else if (finali == 2) {
                    Intent intent = new Intent(MainActivity.this, ActivityThree.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");

                } else if (finali == 3) {
                    Intent intent = new Intent(MainActivity.this, ActivityFour.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");

                } else if (finali == 4) {
                    Intent intent = new Intent(MainActivity.this, ActivityFive.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");
                } else if (finali == 5) {
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent);
                    CustomIntent.customType(MainActivity.this, "left-to-right");
                }
            });
        }
    }
}