package com.example.ali_two_bd.Slider;

public class SliderModel {

    //slider er image resource er jonno 2 ta spurce ase
    //1.drawable (jar location type holo ---int)
    //2.databse or API location(jar location type holo ---string)
    //ekhane banner integer nisi karon ami drawable thaikka banner access korabo,,,,,
    //jokhon api connection anbi tokhon string e convert kore dio
    private int Banner;

    public int getBanner() {
        return Banner;
    }

    public void setBanner(int banner) {
        Banner = banner;
    }

    public SliderModel(int banner) {
        Banner = banner;
    }
}
