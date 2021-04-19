package com.example.onezero;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class Activity_pars_data extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;

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

    public void map(View view) {
        Intent intent = new Intent(Activity_pars_data.this, MapsActivity.class);
        startActivity(intent);
    }

    public void Call(View view) {
        String number = textView3.getText().toString();
        Intent intent2 = new Intent(Intent.ACTION_DIAL);
        intent2.setData(Uri.parse("tel:" + number));
        startActivity(intent2);
    }
}