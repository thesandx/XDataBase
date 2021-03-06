package com.example.manojkumarjha.xdatabase;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DataBase helper=new DataBase(this);

    EditText email,username,name,password1,password2;
    Button signup;

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                /**Intent homeintent = new Intent(this,LogIn.class);
                homeintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeintent); */
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (getActionBar()!=null)
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (NullPointerException e){
            System.out.println("crash ho gya");
        }
        setContentView(R.layout.activity_sign_up);





        signup=(Button) findViewById(R.id.sign_up_btn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email=(EditText) findViewById(R.id.sign_up_email);
                username=(EditText) findViewById(R.id.sign_up_usrname);
                name=(EditText) findViewById(R.id.sign_up_name);
                password1=(EditText) findViewById(R.id.sign_up_ps1);
                password2=(EditText) findViewById(R.id.sign_up_ps2);

                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String unamestr = username.getText().toString();
                String pass1str = password1.getText().toString();
                String pass2str = password2.getText().toString();

                if (namestr.length()>0 && emailstr.length()>0 && unamestr.length()>0 && pass1str.length()>0) {

                    if (!pass1str.equals(pass2str)) {
                        Toast pass = Toast.makeText(SignUp.this, R.string.signup_pass_error, Toast.LENGTH_SHORT);
                        pass.show();
                    } else {
                        Contact c = new Contact();
                        c.setName(namestr);
                        c.setEmail(emailstr);
                        c.setUname(unamestr);
                        c.setPass(pass1str);

                        helper.insertContact(c);
                        Toast pass = Toast.makeText(SignUp.this,R.string.signup_btn_sucess, Toast.LENGTH_SHORT);
                        pass.show();

                    }
                }
                else
                {
                    Toast.makeText(SignUp.this, R.string.signup_btn_error, Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
}
