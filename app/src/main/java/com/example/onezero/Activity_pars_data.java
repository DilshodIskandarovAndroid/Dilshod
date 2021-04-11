package com.example.onezero;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.security.spec.DSAPrivateKeySpec;


public class Activity_pars_data extends AppCompatActivity {

    TextView textView1, textView2,textView3,textView4;
    private static final String TAG ="MapsActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;


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

        if(isServicesOK()) {
            init();
        }
    }

    private void init(){
        Button btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(view -> {
            Intent intent = new Intent(Activity_pars_data.this, MapsActivity.class);
            startActivity(intent);
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Activity_pars_data.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Activity_pars_data.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }



//
//    public void map(View view)
//    {
//        Intent intent = new Intent(Activity_pars_data.this, MapsActivity.class);
//        startActivity(intent);
//    }
}