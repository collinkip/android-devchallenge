package com.example.whack_a_mole;

import android.app.Application;

public class MyApplication extends Application {

    My_friends my_friends =new My_friends();
    public My_friends getMy_friends() {
        return my_friends;
    }

    public void setMy_friends(My_friends my_friends) {
        this.my_friends = my_friends;
    }

}
