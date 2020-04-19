package com.example.ali_two_bd.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ali_two_bd.R;


public class RegisterActivity extends AppCompatActivity  {

    private EditText fullname,mobile,email,streeatadd,password,conpassword;
    private Button registerBtn;
    UserDetails userDetails;
    MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname=findViewById(R.id.fullNameId);
        mobile=findViewById(R.id.mobileId);
        email=findViewById(R.id.emailId);
        streeatadd=findViewById(R.id.streetId);
        password=findViewById(R.id.passwordId);
        conpassword=findViewById(R.id.confirmPassId);
        registerBtn=findViewById(R.id.register_Pager_signUp_Btn);

        databaseHelper=new MyDatabaseHelper(this);

        userDetails = new UserDetails();



        Toolbar toolbar = findViewById(R.id.title_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = fullname.getText().toString();
                String mobile_num= mobile.getText().toString();
                String memail= email.getText().toString();
                String mAddress= streeatadd.getText().toString();
                String mpassword= password.getText().toString();
                String mconpass= conpassword.getText().toString();


                userDetails.setName(fullName);
                userDetails.setMobile(mobile_num);
                userDetails.setEmail(memail);
                userDetails.setAddress(mAddress);
                userDetails.setPassword(mpassword);
                userDetails.setConformPassword(mconpass);



              long rowId =  databaseHelper.insertData(userDetails);

              if (rowId>0)
              {
                  Toast.makeText(getApplicationContext(),rowId+" You Are successful Registered",Toast.LENGTH_SHORT).show();

              }
              else
              {
                  Toast.makeText(getApplicationContext(),"Row inserted  failed",Toast.LENGTH_SHORT).show();

              }

            }
        });

    }






    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            RegisterActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }



    }



/*
public void division(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.dhakaid:
                Toast.makeText(this, "Dhaka", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.sylId:
                Toast.makeText(this, "Sylhet", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rangid:
                Toast.makeText(this, "Rangpur", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.rajid:
                Toast.makeText(this, "Rajshahi", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mymenid:
                Toast.makeText(this, "Mymensingh", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.khulnaid:
                Toast.makeText(this, "Khulna", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ctgid:
                Toast.makeText(this, "Chittagong", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.barisalid:
                Toast.makeText(this, "Barisal", Toast.LENGTH_SHORT).show();
                return true;

                default:
                return false;


        }

 */



