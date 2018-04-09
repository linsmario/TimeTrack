package com.scrum5bwi.timetrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by snyderL on 19.02.18.
 */

public class StopWatch {
    private long startTime;
    private long currentTime;

    private ArrayList<Long> roundsList = new ArrayList<>();

    private boolean paused = false;
    private boolean started = false;
    private ArrayList<Long> pauseList = new ArrayList<>();
    private ArrayList<Long> resumeList = new ArrayList<>();

    public StopWatch() {
        startTime = System.currentTimeMillis();
        currentTime = startTime;
    }

    public String getCurrentTime() {
        if(!paused) {
            long timeSinceStart = System.currentTimeMillis() - startTime;
            long pauseDurations = 0;

            for (int i = 0; i < pauseList.size(); i++) {
                long pauseTime = pauseList.get(i);
                long resumeTime;
                if (paused) {
                    resumeTime = System.currentTimeMillis();
                } else {
                    resumeTime = resumeList.get(i);
                }

                pauseDurations += resumeTime - pauseTime;
            }
            currentTime = timeSinceStart - pauseDurations;
        }
        return getTimeString(currentTime);
    }

    public void startTime() {
        startTime = System.currentTimeMillis();
        started = true;
    }

    public boolean isStarted() {
        return started;
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

    public ArrayList<String> getPauseTimes() {
        ArrayList<String> pauseTimes = new ArrayList<>();
        for (int i = 0; i < pauseList.size(); i++) {
            pauseTimes.add(getTimeString(pauseList.get(i)));
        }
        return pauseTimes;
    }

    public ArrayList<String> getResumeTimes() {
        ArrayList<String> resumeTimes = new ArrayList<>();
        for (int i = 0; i < resumeList.size(); i++) {
            resumeTimes.add(getTimeString(resumeList.get(i)));
        }
        return resumeTimes;
    }

    public String getLastPauseTime() {
        return  getTimeString(pauseList.get(pauseList.size() - 1));
    }

    public String getLastResumeTime() {
        return  getTimeString(resumeList.get(resumeList.size() - 1));
    }

    private String getTimeString(long timeStamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); // milliseconds are SS if needed...
        SimpleDateFormat shortDateFormat = new SimpleDateFormat("mm:ss");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        String timeString;

        if(hourFormat.format(timeStamp).equals("00")) {
            timeString = shortDateFormat.format(timeStamp);
        } else {
            timeString = dateFormat.format(timeStamp);
        }

        return timeString;
    }


}
