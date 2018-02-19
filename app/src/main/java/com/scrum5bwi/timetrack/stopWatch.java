package com.scrum5bwi.timetrack;

import java.util.ArrayList;

/**
 * Created by snyderL on 19.02.18.
 */

public class stopWatch {
    private long startTime;

    private ArrayList<Long> roundsList = new ArrayList<>();

    private ArrayList<Long> pauseList = new ArrayList<>();
    private ArrayList<Long> resumeList = new ArrayList<>();

    public stopWatch() {
        startTime = System.currentTimeMillis();
    }

    public String getCurrentTime() {
        long timeSinceStart = System.currentTimeMillis() - startTime;
        long pauseDurations = 0;

        if(pauseList.size() != 0) {
            for (int i = 0; i < pauseList.size(); i++) {
                pauseDurations += resumeList.get(i) - pauseList.get(i);
            }
        }

        return Long.toString(timeSinceStart - pauseDurations);
    }

}
