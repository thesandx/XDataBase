package com.example.manojkumarjha.xdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Welcome extends AppCompatActivity {
    DataBase helper=new DataBase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView data = (TextView)findViewById(R.id.txtview);
        ListView listView = (ListView)findViewById(R.id.dataListView);
        ArrayList dataItem = new ArrayList();
        Cursor res = helper.getData();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            int i = 1;
            if (res != null && res.getCount() > 0) {
                while (res.moveToNext()) {

                    stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Name: " + res.getString(1) + "\n");
                    stringBuffer.append("Email: " + res.getString(2) + "\n");
                    stringBuffer.append("username: " + res.getString(3) + "\n");
                    stringBuffer.append("password: " + res.getString(4) + "\n" + "\n");
                    System.out.println("sara data append kr liye "+i+" bar");
                    i++;
                }
               data.setText(stringBuffer.toString());
                System.out.println("textview me settext kr diye");
                Toast.makeText(this, "data retrived suceesfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "nothing to show", Toast.LENGTH_SHORT).show();
            }
        }catch (NumberFormatException nfe) {
            Log.e("tag", "msg");
            Toast.makeText(this,"error in catch",Toast.LENGTH_SHORT).show();

        }





      /*  WebView browser = (WebView)findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.facebook.com");*/
    }

 /*    public void onBtnClick(View v){
        EditText editText = (EditText)findViewById(R.id.idTxt);
        String s = editText.getText().toString();
       WebView browser = (WebView)findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(s);*/
    }

