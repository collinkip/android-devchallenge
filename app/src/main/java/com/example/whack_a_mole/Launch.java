package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Launch extends AppCompatActivity {
    Button btnCreate;
    TextView btnLogin;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        btnCreate=findViewById(R.id.btn_create);
        btnLogin=findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {
            Intent intent=new Intent(view.getContext(),Login.class);
            startActivity(intent);
        });
        btnCreate.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(),MainActivity.class));
        });

    }

}