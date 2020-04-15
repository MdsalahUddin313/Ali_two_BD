package com.example.ali_two_bd.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ali_two_bd.R;
public class Account extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_account, container, false);
    return  viewGroup;
    }
}
