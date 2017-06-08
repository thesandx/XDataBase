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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void signIn(View v) {

        if (v.getId() == R.id.login_loginbtn) {
            EditText a = (EditText) findViewById(R.id.log_in_usrname);
            EditText b = (EditText) findViewById(R.id.log_in_pass);

            String str = a.getText().toString();
            String pass = b.getText().toString();

            if (str.length()>0 && pass.length()>0) {

                String password = helper.searchPass(str);
                if (pass.equals(password)) {
                    Intent intent = new Intent(LogIn.this, Welcome.class);
                    startActivity(intent);
                } else {
                    Toast temp = Toast.makeText(LogIn.this, "invalid username/password", Toast.LENGTH_SHORT);
                    temp.show();
                }
            }
            else{
                Toast.makeText(LogIn.this, "please enter username/password", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.login_signupbtn)
        {
            Intent i = new Intent(LogIn.this,SignUp.class);
            startActivity(i);
        }

    }

}
