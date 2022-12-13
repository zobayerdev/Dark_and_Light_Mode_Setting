package com.trodev.motion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {

    ImageView sun, dayLand, nightLand, moon;
    View daySky, nightSky;
    DayNightSwitch dayNightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find this id
        sun = findViewById(R.id.sun);
        dayLand = findViewById(R.id.day_land);
        nightLand = findViewById(R.id.night_land);
        daySky = findViewById(R.id.day_bg);
        nightSky = findViewById(R.id.night_bg);
        dayNightSwitch = findViewById(R.id.day_night_switch);
        moon = findViewById(R.id.moon);

        sun.setTranslationY(-200);
        // moon.setTranslationY(-110);

        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    moon.animate().translationY(-200).setDuration(1000);
                    sun.animate().translationY(90).setDuration(1000);
                    dayLand.animate().alpha(0).setDuration(1000);
                    daySky.animate().alpha(0).setDuration(1300);
                } else {
                    moon.animate().translationY(90).setDuration(1000);
                    sun.animate().translationY(-200).setDuration(1000);
                    dayLand.animate().alpha(1).setDuration(1000);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });

    }
}