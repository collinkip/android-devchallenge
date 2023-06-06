package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class person_Create extends AppCompatActivity {
    Button cancel,btnOk;
    EditText ed_name,ed_age,ed_picNum;
    int edited=-2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_create);

        cancel=findViewById(R.id.btn_cancel);
        btnOk=findViewById(R.id.btn_ok);
        ed_age=findViewById(R.id.et_age);
        ed_name=findViewById(R.id.et_name);
        ed_picNum=findViewById(R.id.et_pic_number);


        Bundle incommingData = getIntent().getExtras();
        if (incommingData !=null){
            String name=incommingData.getString("name");
            int age=incommingData.getInt("age");
            int picture=incommingData.getInt("picture");
            edited=incommingData.getInt("edited");

            ed_name.setText(name);
            ed_age.setText(Integer.toString(age));
            ed_picNum.setText(Integer.toString(picture));
        }


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ed_name.getText().toString().trim();
                String age=ed_age.getText().toString().trim();
                String pic_number=ed_picNum.getText().toString().trim();
                if (name.isEmpty() && age.isEmpty() && pic_number.isEmpty()){
                    return;
                }

                Intent intent=new Intent(view.getContext(),useractivity.class);
                intent.putExtra("edited",edited);
                intent.putExtra("name",name);
                intent.putExtra("age",age);
                intent.putExtra("picture",pic_number);
                startActivity(intent);

            }
        });


    }
}