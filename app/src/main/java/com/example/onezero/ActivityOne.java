package com.example.onezero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private final DatabaseReference root = db.getReference().child("User");
    public static ArrayList<Model> list = new ArrayList<>();
    CardView button1, button2;
    ArrayList<Model> filteredModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Toolbar toolbar = findViewById(R.id.onetoolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        spinner();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        Adapter adapter = new com.example.onezero.Adapter(this, list);
        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Model model = dataSnapshot.getValue(Model.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button1.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_DIAL);
            intent1.setData(Uri.parse("tel:103"));
            startActivity(intent1);
        });
    }

//        button2.setOnClickListener(view -> gotoUrl());
//        button3.setOnClickListener(new android.view.View.OnClickListener() {
//            @Override
//            public void onClick(android.view.View view) {
//                Intent intent2 = new Intent(Intent.ACTION_VIEW);
//                intent2.setData(Uri.parse("geo:41.58960336677057, 60.64229745836222"));
//                Intent chooser = Intent.createChooser(intent2,"Launch Maps");
//                startActivity(chooser);
//            }
//        });
//
//    private void gotoUrl() {
//        Uri uri = Uri.parse("https://www.minzdrav.uz/uz/");
//        startActivity(new Intent(Intent.ACTION_VIEW, uri));
//
//    }

    private void filterList(String status) {
        ArrayList<Model> filteredModels = new ArrayList<>();
        for (Model model : list) {
            if (model.getNomi().toLowerCase().contains(status)) {
                filteredModels.add(model);
            }
        }
        Adapter adapter = new com.example.onezero.Adapter(getApplicationContext(), filteredModels);
        recyclerView.setAdapter(adapter);
    }

    private void spinner() {

        Spinner spinnerviloyat = findViewById(R.id.spinnerviloyat);
        ArrayAdapter<CharSequence> adapterviloyat = ArrayAdapter.createFromResource(this, R.array.Viloyatlar, android.R.layout.simple_spinner_item);
        adapterviloyat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerviloyat.setAdapter(adapterviloyat);
        spinnerviloyat.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textspinner = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, textspinner, Toast.LENGTH_SHORT).show();

        switch (textspinner) {
            case "тошкент": {

                Spinner spinnertuman = findViewById(R.id.spinnertuman);
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Toshkent, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);
                spinnertuman.setOnItemSelectedListener(this);

                break;
            }
            case "андижон": {
                Spinner spinnertuman = findViewById(R.id.spinnertuman);
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Andijon, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);
                spinnertuman.setOnItemSelectedListener(this);

                break;
            }
            case "Вилоятлар кесимида": {
                Spinner spinnertuman = findViewById(R.id.spinnertuman);
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Hechqaysi, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);
                spinnertuman.setOnItemSelectedListener(this);

                break;
            }
        }
//        filterList(textspinner);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
