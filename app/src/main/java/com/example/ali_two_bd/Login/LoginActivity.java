package com.example.ali_two_bd.Login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ali_two_bd.R;


public class LoginActivity extends AppCompatActivity {
    TextView registerText;
    MyDatabaseHelper databaseHelper;

    private Button loginbtn;
    private EditText signinemail,signinpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.title_toolbar);
        registerText = findViewById(R.id.register_text);

        loginbtn=findViewById(R.id.signin_btn_id);

        signinemail=findViewById(R.id.signIn_Email_Id);
        signinpassword=findViewById(R.id.sign_In_password_id);



        databaseHelper=new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();




        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = signinemail.getText().toString();
                String password = signinpassword.getText().toString();

                Boolean result = databaseHelper.findPassword(email,password);
                if (result==true)
                {
                    Intent intent = new Intent(LoginActivity.this,thirdpage.class);
                    Toast.makeText(getApplicationContext(),"You are successfully Login Sir",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"email and password doesn't match",Toast.LENGTH_SHORT).show();
                }
            }

        });


        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Sign in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            LoginActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);





    }




}
