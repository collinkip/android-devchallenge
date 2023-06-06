package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Adapter extends AppCompatActivity {
    TextView tvad;
    EditText ed_name;
    ListView lv_listofnames;
    Button bt_add;
    TextView tvnames;
    List<String> friends =new ArrayList<String>();
    String [] startinglist={"collins ","Cup kit","kip-ub","duckbill"};
    ArrayAdapter ad;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        tvad=findViewById(R.id.textView6);
        tvnames=findViewById(R.id.textView7);
        ed_name=findViewById(R.id.ed_name);
        lv_listofnames=findViewById(R.id.names_list);
        bt_add=findViewById(R.id.submit11);
        final int[] i = {100};


        friends =new ArrayList<>(Arrays.asList(startinglist));
        ad= new ArrayAdapter<>(Adapter.this, android.R.layout.simple_list_item_1,friends);
        lv_listofnames.setAdapter(ad);


        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ed_name.getText().toString();
                friends.add(name);
                Collections.sort(friends);
                ad.notifyDataSetChanged();
            }
        });

       lv_listofnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(Adapter.this, "int ="+i +"name = "+ friends.get(i), Toast.LENGTH_SHORT).show();
           }
       });


    }

}