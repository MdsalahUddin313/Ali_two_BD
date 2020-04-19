package com.example.ali_two_bd.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ali_two_bd.R;

public class MyListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;

    public MyListAdapter(FragmentActivity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.account_list_item, maintitle);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.maintitle=maintitle;
        this.imgid=imgid;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.account_list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.account_list_item_text_id);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.account_list_item_image_id);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    };
}
