package com.scrum5bwi.timetrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by snyderL on 19.02.18.
 */

public class StopWatch {
    private long startTime;

    private ArrayList<Long> roundsList = new ArrayList<>();

    private boolean paused = false;
    private ArrayList<Long> pauseList = new ArrayList<>();
    private ArrayList<Long> resumeList = new ArrayList<>();

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public String getCurrentTime() {
        long timeSinceStart = System.currentTimeMillis() - startTime;
        long pauseDurations = 0;

        for (int i = 0; i < pauseList.size(); i++) {
            long pauseTime = pauseList.get(i);
            long resumeTime;
            if(paused) {
                resumeTime = System.currentTimeMillis();
            } else {
                resumeTime = resumeList.get(i);
            }

            pauseDurations += resumeTime - pauseTime;
        }

        return getTimeString(timeSinceStart - pauseDurations);
    }

    public void pauseTime() {
        if(!paused) {
            pauseList.add(System.currentTimeMillis());
            paused = true;
        }
    }

    public void resumeTime() {
        if(paused) {
            resumeList.add(System.currentTimeMillis());
            paused = false;
        }
    }

    private String getTimeString(long timeStamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
        String timeString  = dateFormat.format(timeStamp);
        return timeString;
    }


}
