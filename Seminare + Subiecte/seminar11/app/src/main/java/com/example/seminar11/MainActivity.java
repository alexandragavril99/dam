package com.example.seminar11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String cheie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Studenti");

        final ListView listView = findViewById(R.id.list_view);
        final List<Student> listaStudenti = new ArrayList<>();



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //cand se face o modificare
                //snapshot-ul ref respective
                //se va apela de fiecare data cand se va face o modificare din baza de date
                listaStudenti.clear();
                Iterable<DataSnapshot> studenti = dataSnapshot.getChildren();
                for(DataSnapshot ds:studenti) {
                    Toast.makeText(getApplicationContext(), ds.getValue().toString(),Toast.LENGTH_SHORT).show();
                    listaStudenti.add(ds.getValue(Student.class));
                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaStudenti);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student stud = listaStudenti.get(position);

                EditText etNume = findViewById(R.id.etNume);
                etNume.setText(stud.getNume());

                EditText etVarsta = findViewById(R.id.etVarsta);
                etVarsta.setText(stud.getVarsta()+"");

                EditText etMedia = findViewById(R.id.etMedia);
                etMedia.setText("" +stud.getMedie());

                cheie = stud.getNrMatricol();
            }
        });

    }

    public void inserareInFirebase(View view) {
        Student s = new Student("307","Ionescu",22, 8.99f);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Studenti");
        DatabaseReference studentRef = myRef.child("Student-"+s.getNrMatricol());
        studentRef.setValue(s);
    }

    public void modificareInFirebase(View view) {
        EditText etNume = findViewById(R.id.etNume);
        EditText etVarsta = findViewById(R.id.etVarsta);
        EditText etMedia = findViewById(R.id.etMedia);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Studenti");
        DatabaseReference studentRef = myRef.child("Student-"+cheie);

        Student s = new Student(cheie, etNume.getText().toString(), Integer.parseInt(etVarsta.getText().toString()), Float.parseFloat(etMedia.getText().toString()));
        studentRef.setValue(s);
    }
}