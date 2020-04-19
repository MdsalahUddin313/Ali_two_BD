package com.example.ali_two_bd;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.ali_two_bd.Fragments.Account;
import com.example.ali_two_bd.Fragments.Cart;
import com.example.ali_two_bd.Fragments.Home;
import com.example.ali_two_bd.Fragments.Products;
import com.example.ali_two_bd.Fragments.store;

public class BottomNevigation_view extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nevigation_view);
        Fragment fragment = null;
        final FragmentManager fm = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nevigation_view_id);
        //loading the default fragmen
        //getting bottom navigation view and attaching the listener
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);


        //for auto show search screen
        fragment = new Home();
        loadFragment(fragment);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = new Home();

                break;

            case R.id.Store_Bottom_menu_id:
                fragment = new store();
                break;

            case R.id.Product_Bottom_menu_id:
                fragment = new Products();
                break;
            case R.id.Cart_Bottom_menu_id:
                fragment = new Cart();
                break;

            case R.id.Account_Bottom_menu_id:
                fragment = new Account();
                break;
        }

        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_id, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
