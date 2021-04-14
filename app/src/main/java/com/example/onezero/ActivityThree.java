package com.example.onezero;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ActivityThree extends AppCompatActivity {

    private EditText nomisave, manzilisave, raqamisave, joylashuvisave;
    private Button save;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("User");

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        nomisave = findViewById(R.id.nomisave);
        manzilisave = findViewById(R.id.manzilisave);
        raqamisave = findViewById(R.id.raqamisave);
        joylashuvisave = findViewById(R.id.joylashuvisave);
        save = findViewById(R.id.save);

        save.setOnClickListener(v -> {
            String nomi = nomisave.getText().toString();
            String manzili = manzilisave.getText().toString();
            String raqami = raqamisave.getText().toString();
            String joylashuvi = joylashuvisave.getText().toString();

            HashMap<String , String> userMap = new HashMap<>();

            userMap.put("nomi" , nomi);
            userMap.put("manzili" , manzili);
            userMap.put("raqami" , raqami);
            userMap.put("joylashuvi" , joylashuvi);


            root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(ActivityThree.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}