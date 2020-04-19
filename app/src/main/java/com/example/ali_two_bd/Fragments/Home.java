package com.example.ali_two_bd.Fragments;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.example.ali_two_bd.R;
import com.example.ali_two_bd.Slider.SliderAdapter;
import com.example.ali_two_bd.Slider.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends Fragment {

    ViewPager banner_Slider_viewpager;
    private List<SliderModel> sliderModelList;
    private int currentpage=2;
    private Timer timer;
    final private long DELAY=1000;
    final private long PERIOD_TIME=1000;
    private  Toolbar toolbar;
    private Object ActionBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
//        Toolbar myToolbar = viewGroup.findViewById(R.id.home_toolbar_id);
  //      viewGroup.setActivated(true);
        Statusbar_color_change();

       //toolbar=viewGroup.findViewById(R.id.home_toolbar_id);
        //getActivity().getSupportActionBar(toolbar).setTitle();

        banner_Slider_viewpager=viewGroup.findViewById(R.id.view_pager_id);
        sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_three));
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_four));

        //our main array
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_one));
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_two));
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_three));
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_four));


        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_one));
        sliderModelList.add(new SliderModel(R.drawable.advertise_banner_two));



        ///setting our Adapters
        SliderAdapter sliderAdapter=new SliderAdapter(sliderModelList);
        banner_Slider_viewpager.setAdapter(sliderAdapter);
        banner_Slider_viewpager.setClipToPadding(false);
        banner_Slider_viewpager.setPageMargin(60);
        banner_Slider_viewpager.setCurrentItem(currentpage);
        //changin your view pager according to your direction
        //whenever we change our atributes it control our page's color or view
        ViewPager.OnPageChangeListener onpageChangeListener=new ViewPager.OnPageChangeListener() {
            //if we change any color of our viewes with scroll ,,,we can use OnpageScroll method
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                currentpage=i;
            }
            @Override
            public void onPageScrollStateChanged(int i) {
                if(i==ViewPager.SCROLL_STATE_IDLE){
                    pagelooper();
                }
            }
        };
        //set onpageChangeListener in bannerSliderSlideshow(banner e jate show kore emon slider set kora hoise)
        banner_Slider_viewpager.setOnPageChangeListener(onpageChangeListener);
        //

        //this function start banner animation
        StartBannerSlideshow();
        //user banner touch korle ki hobe????
        //1.banner er slide off hoye jabe
        //2.and touch sere dile banner slide shuru hoye jabe
        //setOnTouchListener(new View.OnTouchListener() ei 2 ta kaj ei korse
        banner_Slider_viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pagelooper();
                StopBannerSlideshow();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    StartBannerSlideshow();
                }
                return false;
            }
        });
        return viewGroup;

    }

    private void pagelooper(){
        if(currentpage==(sliderModelList.size()-2)){
           currentpage=2;
           banner_Slider_viewpager.setCurrentItem(currentpage,false);
        }

        if(currentpage==1){
            currentpage=(sliderModelList.size()-3);
            banner_Slider_viewpager.setCurrentItem(currentpage,false);
        }


    }

    private void StartBannerSlideshow(){

        final Handler handler =new Handler();
        final Runnable update =new Runnable() {
            @Override
            public void run() {
                if(currentpage>=sliderModelList.size()){
                    currentpage=1;
                }
                banner_Slider_viewpager.setCurrentItem(currentpage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY,PERIOD_TIME);
    }

    private void StopBannerSlideshow(){
        timer.cancel();
    }



    void Statusbar_color_change(){
        //change the status bar color...............................
        if(Build.VERSION.SDK_INT>=21){
            Window window = getActivity().getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
// finally change the color
            window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorPrimaryDark));
        }

    }
}
