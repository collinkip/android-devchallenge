package com.example.whack_a_mole;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbhelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String CUSTOMERNAME = "CUSTOMERNAME";
    public static final String IS_ACTIVE = "IS_ACTIVE";
    public static final String CUSTOMEREMAIL = "CUSTOMEREMAIL";
    public static final String CUSTOMERAGE = "CUSTOMERAGE";

    public Dbhelper(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table " + CUSTOMER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + CUSTOMERNAME + " TEXT," + CUSTOMERAGE + " INT," + CUSTOMEREMAIL + " TEXT UNIQUE," + IS_ACTIVE + " BOOL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Customer customer){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(CUSTOMERNAME,customer.getName());
        cv.put(CUSTOMERAGE,customer.getAge());
        cv.put(CUSTOMEREMAIL,customer.getEmail());

        long insert=sq.insert(CUSTOMER_TABLE,null,cv);
        return insert != -1;
    }

    public <Int> List<Customer> everyone(){

        List<Customer> resultList=new ArrayList<>();
        String sql="Select * from "+CUSTOMER_TABLE;

        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                int ID=cursor.getInt(0);
                String name=cursor.getString(1);
                int age=cursor.getInt(2);
                String email=cursor.getString(3);
                boolean is_Active=cursor.getInt(4) == 1 ? true:false ;

                Customer customer=new Customer(ID,name,email,age,is_Active);

                resultList.add(customer);

            }
            while (cursor.moveToNext());

        }
        else {
        }
        cursor.close();
        db.close();

        return resultList;
    }



}
