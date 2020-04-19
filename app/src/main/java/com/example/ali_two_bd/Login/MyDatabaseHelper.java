package com.example.ali_two_bd.Login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "Id";
    private static final String FULLNAME = "Fullname";
    private static final String MOBILE = "Mobile";
    private static final String EMAIL = "Email";
    private static final String ADDRESS = "Address";
    private static final String PASSWORD = "Password";
    private static final String CONFIRMPASSWORD = "Confirmpassword";
    private static final int VERSION_NUMBER = 1;
    private Context context;

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FULLNAME+" VARCHAR(255) NOT NULL,"+MOBILE+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+ADDRESS+" VARCHAR(255) NOT NULL,"+PASSWORD+" TEXT NOT NULL,"+CONFIRMPASSWORD+" TEXT NOT NULL);";

    private static final String DROP_TABLE = "DROP TABLE  IF EXISTS'TABLE_NAME';";

    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null,VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {


        try {

            Toast.makeText(context, "OnCreate is Created", Toast.LENGTH_SHORT).show();

            db.execSQL(CREATE_TABLE);


        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


        try {

            Toast.makeText(context, "OnUpgrade is Created", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);


        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();

        }

    }
    public  long  insertData(UserDetails userDetails)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FULLNAME,userDetails.getName());
        contentValues.put(MOBILE,userDetails.getMobile());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(ADDRESS,userDetails.getAddress());
        contentValues.put(PASSWORD,userDetails.getPassword());
        contentValues.put(CONFIRMPASSWORD,userDetails.getConformPassword());

        long rowId =  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return rowId;

    }

    public Boolean findPassword(String memail , String mpassword) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from TABLE_NAME", null);

        Boolean result = false;

        if (cursor.getCount() == 0) {
            Toast.makeText(context, "No Data is Found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext())
            {
                String email = cursor.getString(4);
                String password = cursor.getString(6);



                if (email.equals(memail) && password.equals(mpassword))
                {
                    result = true;
                    break;


                }


            }

        }


        return result;


    }

}


