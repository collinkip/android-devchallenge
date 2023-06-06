package com.example.whack_a_mole;

import android.app.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class My_friends {
    List<person> myFriendList;

    public My_friends(List<person> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public List<person> getMyFriendList() {
        return myFriendList;
    }

    public void setMyFriendList(List<person> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public My_friends(){
        String[] startinglist={"Collins","Bobbly","Duckbilly"};
        this.myFriendList=new ArrayList<>();
        Random rng=new Random();
         for (int i=0; i < startinglist.length;i++){
             person p= new person(startinglist[i],rng.nextInt(50)+18,rng.nextInt(32));
             myFriendList.add(p);
         }
    }

}
