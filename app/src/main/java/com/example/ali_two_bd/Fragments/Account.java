package com.example.ali_two_bd.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ali_two_bd.Login.Login_page;
import com.example.ali_two_bd.R;
public class Account extends Fragment {
    ListView list;
    String[] maintitle={
            "My Profile","My Order",
            "My Request","Find Tax",
            "Notification","FAQ","Terms &Condition","Support Center","About Us",
    };

    Integer[] imgid={
            R.drawable.ic_account_24dp,R.drawable.ic_products_24dp,
            R.drawable.ic_store_24dp,R.drawable.ic_cart_24dp,
            R.drawable.ic_bell_24dp,R.drawable.ic_products_24dp,
            R.drawable.ic_store_24dp,R.drawable.ic_cart_24dp,
            R.drawable.ic_bell_24dp,
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_account, container, false);

        MyListAdapter adapter=new MyListAdapter(getActivity(), maintitle,imgid);
        list=viewGroup.findViewById(R.id.account_listview_id);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Intent i=new Intent(getActivity(), Login_page.class);startActivity(i);
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getActivity(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getActivity(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getActivity(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getActivity(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return  viewGroup;
    }
}
