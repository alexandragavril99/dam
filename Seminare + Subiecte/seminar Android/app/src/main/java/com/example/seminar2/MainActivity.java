package com.example.seminar2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        {
            private int reqCodeRegisterActivity = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        //btn.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ai apasat aici butonu",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), seminar4Activity.class);
                intent.putExtra("nume","Ionelule");
                startActivityForResult(intent,101);
            }
        });
        Button btn2 = findViewById(R.id.button3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ai apasat aici butonu2",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                //startActivity(it);
                intent.putExtra("nume","Popescu");
                intent.putExtra("parola","parola");
                intent.putExtra("id",101);
                startActivityForResult(intent,reqCodeRegisterActivity);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == reqCodeRegisterActivity) {
            if(resultCode == RESULT_OK) {
                //procesarea informatiei trimise
                Bundle bundle = data.getExtras();
                String text = bundle.getString("text");
                int numar = bundle.getInt("numar", 0);
                User user = bundle.getParcelable("user");

                Toast.makeText(this,data.getStringExtra("text"), Toast.LENGTH_SHORT).show();

            }
            if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this,"Utilizatorul a renuntat la modificari",Toast.LENGTH_SHORT).show();
            }
        }
    }

            //    public void metodaNextActivity(View sender) {
//        Toast.makeText(this,"Ai apasat butonul",Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"Ai apasat ListenerThis",Toast.LENGTH_SHORT).show();
    }
}

//metoda 2: facem o alta clasa care implementeaza onclicklistener si ii dam un obiect de tipul acelei clasei
//metoda 3: suprascriem interfata onclicklistener