package com.example.whack_a_mole;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Person_adapter extends BaseAdapter {
    public Person_adapter(Activity mActivity, My_friends myfriend) {
        this.mActivity = mActivity;
        this.myfriend = myfriend;
    }

    Activity mActivity;
    My_friends myfriend;


    @Override
    public int getCount() {
        return myfriend.getMyFriendList().size();
    }

    @Override
    public person getItem(int i) {
        return myfriend.myFriendList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View onepersonline;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        onepersonline=inflater.inflate(R.layout.userlayout,viewGroup,false);

        TextView tv_name=onepersonline.findViewById(R.id.tv_name);
        TextView tv_age=onepersonline.findViewById(R.id.tv_age);
        ImageView img=onepersonline.findViewById(R.id.img_pic);

        person p =this.getItem(i);

        tv_name.setText(p.getName());
        tv_age.setText(Integer.toString(p.getAge()));
        img.setImageResource(R.drawable.user);

        return onepersonline;
    }
}
