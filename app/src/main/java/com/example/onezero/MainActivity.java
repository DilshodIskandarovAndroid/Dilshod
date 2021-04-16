package com.example.onezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.birnchiitem){

        }
        return true;
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