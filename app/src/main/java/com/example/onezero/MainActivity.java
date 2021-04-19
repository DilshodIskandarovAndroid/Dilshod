package com.example.onezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

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

            Toast.makeText(this, "Созламалар", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplicationContext(),Collapsing.class);
            startActivity(intent);

        }else if (id == R.id.ikkinchiitem){
            Toast.makeText(this, "Созламалар", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.uchinchiitem){
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(intent, "ShareVia"));
        }
        else if (id == R.id.tortinchiitem){
            Toast.makeText(this, "Созламалар", Toast.LENGTH_SHORT).show();
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