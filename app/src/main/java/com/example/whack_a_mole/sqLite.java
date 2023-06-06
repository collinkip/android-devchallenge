package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;


public class sqLite extends AppCompatActivity {
    EditText etname,etage,etemail;
    Button submit,getdata;

    Switch aSwitch;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lite);

        etname = findViewById(R.id.et_name);
        etage = findViewById(R.id.et_age);
        etemail = findViewById(R.id.et_pic_number);
        submit = findViewById(R.id.submit);
        getdata = findViewById(R.id.get_data);
        listView = findViewById(R.id.lv_names);
        aSwitch=findViewById(R.id.switch1);


        etemail.setHint("Enter Email");


        submit.setOnClickListener(view -> {
            Customer customer = null;
            String name=etname.getText().toString();
            String age=etage.getText().toString();
            String email=etemail.getText().toString();
            if (name.isEmpty() && age.isEmpty() && email.isEmpty()) {
                Toast.makeText(this, "Input is missing", Toast.LENGTH_SHORT).show();
                return;
            }
            customer=new Customer(1,name,email,Integer.parseInt(age),aSwitch.isChecked());

            Dbhelper dbhelper=new Dbhelper(this);
            if (dbhelper.addOne(customer)){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });
        getdata.setOnClickListener(view -> {
            Dbhelper dbhelper=new Dbhelper(view.getContext());
            List<Customer> everyone=dbhelper.everyone();

            Toast.makeText(this, "Everyone "+everyone, Toast.LENGTH_SHORT).show();


        });

    }
}