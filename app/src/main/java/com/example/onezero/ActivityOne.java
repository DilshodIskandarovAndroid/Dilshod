package com.example.onezero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class ActivityOne extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private final DatabaseReference root = db.getReference().child("User");
    public static ArrayList<Model> list = new ArrayList<>();
    CardView button1, button2;

      private Button button3;
// Yuklandimi?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        initsearch();
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//      button3 = findViewById(R.id.btn3);
//        FirebaseRecyclerOptions<Model> options =
//                new FirebaseRecyclerOptions.Builder<Model>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("User"), Model.class)
//                        .build();

        list = new ArrayList<>();

        Adapter adapter = new com.example.onezero.Adapter(this,list);
        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {

                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
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

        button2.setOnClickListener(view -> gotoUrl());

//        button3.setOnClickListener(new android.view.View.OnClickListener() {
//            @Override
//            public void onClick(android.view.View view) {
//                Intent intent2 = new Intent(Intent.ACTION_VIEW);
//                intent2.setData(Uri.parse("geo:41.58960336677057, 60.64229745836222"));
//                Intent chooser = Intent.createChooser(intent2,"Launch Maps");
//                startActivity(chooser);
//            }
//        });

    }

    private void initsearch()
    {
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                ArrayList<Model> filteredModels = new ArrayList<>();
                for (Model model: list)
                {
                    if (model.getNomi().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredModels.add(model);

                    }
                }

                Adapter adapter = new com.example.onezero.Adapter(getApplicationContext(), filteredModels);
                recyclerView.setAdapter(adapter);

                return false;
            }
        });

    }





    private void gotoUrl()
    {
        Uri uri = Uri.parse("https://www.minzdrav.uz/uz/");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    private void filterList(String status)
    {
//
        ArrayList<Model> filteredModels = new ArrayList<>();
        for (Model model : list)
        {
            if (model.getNomi().toLowerCase().contains(status ))
            {
                filteredModels.add(model);
            }
        }
        Adapter adapter = new com.example.onezero.Adapter(getApplicationContext(), filteredModels);
        recyclerView.setAdapter(adapter);
    }

    public void btns1(View view) {

        Adapter adapter = new com.example.onezero.Adapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
    }

    public void btns2(View view) {
        filterList("urganch");

    }

    public void btns3(View view) {
        filterList("shovot");
    }
}
