package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class useractivity extends AppCompatActivity {
    Button  btnAdd,btnAbc,btnAge;
    ListView listView;

    My_friends my_friends;
    Person_adapter person_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);
        btnAbc=findViewById(R.id.sort_abc);
        btnAdd=findViewById(R.id.add_btn);
        btnAge=findViewById(R.id.sort_age);

        listView=findViewById(R.id.list_lv);

        my_friends=((MyApplication)this.getApplication()).getMy_friends();
        person_adapter=new Person_adapter(this,my_friends);
        listView.setAdapter(person_adapter);

        Bundle incomingData=getIntent().getExtras();

        if (incomingData != null){
            int edited=incomingData.getInt("edited");
            String name=incomingData.getString("name");
            int age=Integer.parseInt(incomingData.getString("age"));
            int pictureNumber=Integer.parseInt(incomingData.getString("picture"));

            person p= new person(name,age,pictureNumber);

            if (edited>-1){
                my_friends.getMyFriendList().remove(edited);
            }
            my_friends.getMyFriendList().add(p);
            person_adapter.notifyDataSetChanged();

        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),person_Create.class);
                startActivity(intent);
            }
        });

        btnAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(my_friends.getMyFriendList());
                person_adapter.notifyDataSetChanged();
            }
        });
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(my_friends.getMyFriendList(), new Comparator<person>() {
                    @Override
                    public int compare(person person, person t1) {
                        return person.age - t1.age;
                    }
                });
                person_adapter.notifyDataSetChanged();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openItem(i);
            }
        });




    }

    private void openItem(int i) {
        person p=my_friends.getMyFriendList().get(i);
        Intent intent= new Intent(getApplicationContext(),person_Create.class);
        intent.putExtra("edited",i);
        intent.putExtra("name",p.getName());
        intent.putExtra("age",p.getAge());
        intent.putExtra("picture",p.getPicture_number());

        startActivity(intent);
    }
}