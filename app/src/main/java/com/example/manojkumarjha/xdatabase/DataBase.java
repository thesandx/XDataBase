package com.example.manojkumarjha.xdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MANOJ KUMAR JHA on 29-Mar-17.
 */

public class DataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static  final int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="contacts.db";
    private static  final String TABLE_NAME="contacts";
    private static  final String COLUMN_ID="id";
    private static  final String COLUMN_NAME="name";
    private static  final String COLUMN_EMAIL="email";
    private static  final String COLUMN_UNAME="uname";
    private static  final String COLUMN_PASS="pass";

    private static  final String TABLE_CREATE="create table contacts(id integer primary key not null," +
            "name text not null,email text not null,uname text not null,pass text not null)";


    //constructor
    public DataBase(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        db.execSQL(TABLE_CREATE);


    }

    public void insertContact(Contact c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from contacts";
        //from above query we get to know the number of columns,so that we can assign the unique id to the nxt coloumn.
        Cursor cursor=db.rawQuery(query,null);
        int count =cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASS,c.getPass());
        values.put(COLUMN_UNAME,c.getUname());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Cursor getData(){
        db=this.getWritableDatabase();
        String query="select * from contacts";
        Cursor cursor=db.rawQuery(query,null);
        System.out.println("query dal diye cursor return krne wale hai");
        return cursor;

    }

    public String searchPass(String uname){
        db= this.getReadableDatabase();
        String query="select uname, pass from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do {
                a=cursor.getString(0);
                b=cursor.getString(1);
                if (a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS"+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }


}
