package com.example.onezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity
{

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                } else if (finali == 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent);

                } else if (finali == 2) {
                    Intent intent = new Intent(MainActivity.this, ActivityThree.class);
                    startActivity(intent);

                } else if (finali == 3) {
                    Intent intent = new Intent(MainActivity.this, ActivityFour.class);
                    startActivity(intent);

                } else if (finali == 4) {
                    Intent intent = new Intent(MainActivity.this, ActivityFive.class);
                    startActivity(intent);
                } else if (finali == 5) {
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent);
                }
            });
        }
    }
}