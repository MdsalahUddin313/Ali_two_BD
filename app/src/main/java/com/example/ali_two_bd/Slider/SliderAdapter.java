package com.example.ali_two_bd.Slider;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ali_two_bd.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private List<SliderModel> sliderModelList;

    public SliderAdapter(List<SliderModel> sliderAdapters) {
        this.sliderModelList = sliderAdapters;
    }


    //this method helps to send any request to our root layout
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.slider_layout,container,false);
        ImageView BannerImage=view.findViewById(R.id.Slider_banner_id);
        //sliderModer.get(position).getBanner()
        BannerImage.setImageResource(sliderModelList.get(position).getBanner());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return sliderModelList.size();
    }
}
