package com.example.dam_bilet4_sesizare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String LISTA = "lista";

    //https://pastebin.com/raw/wdDUhB06
    //api.mocki.io/v1/8e006aed


    ArrayList<Sesizare> sesizareList = new ArrayList<>();
    private static SharedPreferences sharedPreferences;
    public static final Date DATE = new Date(System.currentTimeMillis());
    private int REQUEST_CODE = 201;
    private static SesizareDAO sesizariDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        long date = DATE.getTime();
        editor.putLong("data", date);
        editor.commit();

        sesizariDAO = Room.databaseBuilder(getApplicationContext(), SesizareDB.class, "SesizareDB").fallbackToDestructiveMigration()
                .build().getSesizariDAO();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Sesizare> sesizariSelect = sesizariDAO.getSesizari();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("Lista din DB: ", sesizariSelect.toString());
                    }
                });
            }
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);

         if(item.getItemId() == R.id.adaugaSesizare) {
             Intent intent = new Intent(getApplicationContext(),AdaugaSesizareActivity.class);
             startActivityForResult(intent,REQUEST_CODE);
         }

         if(item.getItemId() == R.id.despre) {
             sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
             long date = sharedPreferences.getLong("data",0);
             Date data = new Date(date);
             Toast.makeText(this, getString(R.string.nume_student) + " " + data.toString(), Toast.LENGTH_SHORT).show();
         }

         if(item.getItemId() == R.id.listaSesizari) {
             Toast.makeText(getApplicationContext(), sesizareList.toString(), Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(getApplicationContext(),ListaSesizariActivity.class);
             intent.putExtra(LISTA, sesizareList);
             startActivity(intent);
         }

         if(item.getItemId() == R.id.raport) {
             Intent intent = new Intent(getApplicationContext(),RaportActivity.class);
             startActivity(intent);
         }

         if(item.getItemId() == R.id.preluareSesizariXML) {

             XMLParser parser = new XMLParser(){
                 @Override
                 protected void onPostExecute(ArrayList<Sesizare> sesizares) {
                    // Toast.makeText(MainActivity.this, sesizares.toString(), Toast.LENGTH_SHORT).show();
                     sesizareList.addAll(sesizares);
                     Toast.makeText(getApplicationContext(),sesizareList.toString(),Toast.LENGTH_SHORT).show();
                 }
             };
             parser.execute("https://pastebin.com/raw/wdDUhB06");
         }

         if(item.getItemId() == R.id.preluareSesizariJSON) {
             JSONParser parser = new JSONParser() {
                 @Override
                 protected void onPostExecute(ArrayList<Sesizare> sesizares) {
                     sesizareList.addAll(sesizares);
                     Toast.makeText(getApplicationContext(),sesizareList.toString(),Toast.LENGTH_SHORT).show();
                 }
             };
             parser.execute("https://api.mocki.io/v1/8e006aed");
         }
         return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Sesizare sesizare = (Sesizare) data.getSerializableExtra("obiectCreat");
                sesizareList.add(sesizare);
                Toast.makeText(this, sesizareList.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}