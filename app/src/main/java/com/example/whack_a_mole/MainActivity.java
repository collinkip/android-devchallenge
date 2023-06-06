package com.example.whack_a_mole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button startButton,login,adapter,users,sqlite;
    EditText name,phone;
    TextView namee,phonee;
    View vieww,pview;

    @SuppressLint({"MissingInflatedId", "WrongViewCast", "SuspiciousIndentation"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.button2);
        name=findViewById(R.id.edt_primary_name);
        phone=findViewById(R.id.editTextPhone);
        namee=findViewById(R.id.name);
        phonee=findViewById(R.id.number);
        vieww=findViewById(R.id.layout12);
        pview=findViewById(R.id.primaryview);
        login=findViewById(R.id.button);
        adapter=findViewById(R.id.adaptor);
        users=findViewById(R.id.users);
        sqlite=findViewById(R.id.sqlite);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Notifications.class);
                startActivity(intent);
            }
        });

        startButton.setOnClickListener(view -> {
            String names=name.getText().toString();
            String phones=phone.getText().toString().trim();

            if (names.isEmpty() || phones.isEmpty()){
                Toast.makeText(MainActivity.this, "Phone number or names cannot be empty ", Toast.LENGTH_SHORT).show();
                return;
            }
            else
                namee.setText(names);
                phonee.setText(phones);
                pview.setVisibility(View.GONE);
                vieww.setVisibility(View.VISIBLE);
        });
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Adapter.class);
                startActivity(intent);
            }
        });
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),useractivity.class);
                startActivity(intent);
            }
        });
        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(),sqLite.class);
                startActivity(intent);
            }
        });
    }
}
