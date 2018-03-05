package com.scrum5bwi.timetrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StopWatch stopWatch = new StopWatch();

        while (true) {
            System.out.println("+++++++++++++++");
            System.out.println(stopWatch.getCurrentTime());
            stopWatch.pauseTime();
            System.out.println(stopWatch.getCurrentTime());
            stopWatch.resumeTime();
            System.out.println(stopWatch.getCurrentTime());
        }
    }
}
