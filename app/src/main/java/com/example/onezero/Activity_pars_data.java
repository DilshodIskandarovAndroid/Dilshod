package com.example.onezero;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Activity_pars_data extends AppCompatActivity {

    TextView textView1, textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pars_data);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        textView1.setText(getIntent().getStringExtra("nomi"));
        textView2.setText(getIntent().getStringExtra("manzili"));
        textView3.setText(getIntent().getStringExtra("raqami"));
        textView4.setText(getIntent().getStringExtra("joylashuvi"));

    }
}