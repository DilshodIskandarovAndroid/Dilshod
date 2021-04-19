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
import android.widget.Switch;
import android.widget.TextView;
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
import java.util.Objects;

public class ActivityOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private final DatabaseReference root = db.getReference().child("User");
    public static ArrayList<Model> list = new ArrayList<>();
    CardView button1, button2;

    private Spinner spinnertuman;
    private String viloyatnomi;
    private String tumannomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Toolbar toolbar = findViewById(R.id.onetoolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        spinnertuman = findViewById(R.id.spinnertuman);
        spinnertuman.setOnItemSelectedListener(this);
        spinner();

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

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

        String textspinnerviloyat = parent.getItemAtPosition(position).toString();

        switch (textspinnerviloyat) {

            case "Вилоятлар бўйича саралаш": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Shaharvatumanlar, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                Adapter adapter = new com.example.onezero.Adapter(getApplicationContext(), list);
                recyclerView.setAdapter(adapter);

                break;
            }
            case "Тошкент вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Toshkent, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("тошкент вилояти");
                viloyatnomi = "тошкент вилояти";

                break;
            }
            case "Андижон вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Andijon, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("андижон вилояти");
                viloyatnomi = "андижон вилояти";
                break;
            }
            case "Наманган вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Namangan, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("наманган вилояти");
                viloyatnomi = "наманган вилояти";

                break;
            }
            case "Фарғона вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Fargona, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("фарғона вилояти");
                viloyatnomi = "фарғона вилояти";

                break;
            }
            case "Сирдарё вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Sirdaryo, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("сирдарё вилояти");
                viloyatnomi = "сирдарё вилояти";

                break;
            }
            case "Жиззах вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Jizzax, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("жиззах вилояти");
                viloyatnomi = "жиззах вилояти";

                break;
            }
            case "Самарқанд вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Samarqand, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("самарқанд вилояти");
                viloyatnomi = "самарқанд вилояти";

                break;
            }
            case "Бухоро вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Buxoro, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("бухоро вилояти");
                viloyatnomi = "бухоро вилояти";

                break;
            }

            case "Навоий вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Navoiy, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("навоий вилояти");
                viloyatnomi = "навоий вилояти";
                break;
            }

            case "Қашқадарё вилояти": {
                ArrayAdapter<CharSequence> adaptertuman = ArrayAdapter.createFromResource(this, R.array.Qashqadaryo, android.R.layout.simple_spinner_item);
                adaptertuman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnertuman.setAdapter(adaptertuman);

                filterList("кашқадарё вилояти");
                viloyatnomi = "кашқадарё вилояти";

                break;
            }
        }


        spinnertuman.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positiontuman, long id) {

                String textspinnertuman = parent.getItemAtPosition(positiontuman).toString();

                switch (textspinnertuman) {
                    case "Aнгрен шаҳри": {
                        filterList("тошкент вилояти" + " " + "ангрен шаҳри");
                        break;
                    }

                    case "Бекобод шаҳри": {
                        filterList("тошкент вилояти" + " " + "бекобод шаҳри");
                        break;
                    }
                    case "Бекобод тумани": {
                        filterList("тошкент вилояти" + " " + "бекобод тумани");
                        break;
                    }
                    case "Бўка тумани": {
                        filterList("тошкент вилояти" + " " + "бўка тумани");
                        break;
                    }
                    case "Бўстонлиқ тумани": {
                        filterList("тошкент вилояти" + " " + "бўстонлиқ тумани");
                        break;
                    }
                    case "Чиноз тумани": {
                        filterList("тошкент вилояти" + " " + "чиноз тумани");
                        break;
                    }
                    case "Чирчиқ шаҳри": {
                        filterList("тошкент вилояти" + " " + "чирчиқ шаҳри");
                        break;
                    }
                    case "Ўрта чирчиқ тумани": {
                        filterList("тошкент вилояти" + " " + "ўрта чирчиқ тумани");
                        break;
                    }
                    case "Оҳангарон тумани": {
                        filterList("тошкент вилояти" + " " + "оҳангарон тумани");
                        break;
                    }
                    case "Олмалиқ шаҳри": {
                        filterList("тошкент вилояти" + " " + "олмалиқ шаҳри");
                        break;
                    }
                    case "Оққўрғон тумани": {
                        filterList("тошкент вилояти" + " " + "оққўрғон тумани");
                        break;
                    }
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
