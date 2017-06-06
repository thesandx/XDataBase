package com.example.manojkumarjha.xdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    DataBase helper=new DataBase(this);

     Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login=(Button) findViewById(R.id.login_loginbtn);
        signup=(Button) findViewById(R.id.login_signupbtn);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               EditText a=(EditText) findViewById(R.id.log_in_usrname);
                EditText b=(EditText) findViewById(R.id.log_in_pass);


                String str=a.getText().toString();
                String pass=b.getText().toString();

                String password =helper.searchPass(str);
                if (pass.equals(password)){
                Intent intent=new Intent(LogIn.this,Welcome.class);
                startActivity(intent);
            }
            else{
                Toast temp=Toast.makeText(LogIn.this,"invalid username/password",Toast.LENGTH_SHORT);
                temp.show();
            }}
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this,SignUp.class);
                startActivity(i);
            }
        });
    }
}
