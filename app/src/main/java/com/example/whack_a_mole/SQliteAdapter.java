package com.example.whack_a_mole;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SQliteAdapter  extends RecyclerView.Adapter<SQliteAdapter.myViewHolder> {
    private Context context;

    public SQliteAdapter(View.OnClickListener context, sqLite sqLite, ArrayList name_id, ArrayList age_id, ArrayList email_id) {
        this.context = (Context) context;
        this.name_id = name_id;
        this.age_id = age_id;
        this.email_id = email_id;
    }

    private ArrayList name_id,age_id,email_id;


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.usetlayout,viewGroup,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SQliteAdapter.myViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(String.valueOf(name_id.get(i)));
        myViewHolder.tv_age.setText(String.valueOf(age_id.get(i)));
        myViewHolder.tv_email.setText(String.valueOf(email_id.get(i)));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_age,tv_email;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_age=itemView.findViewById(R.id.tv_age);
            tv_email=itemView.findViewById(R.id.img_pic);
        }
    }
}
