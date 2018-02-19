package com.scrum5bwi.timetrack;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.*;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;
import android.widget.Button;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class ControllingAdapter {

    public int startButton = R.id.buttonLeft;
    public int stopButton = R.id.buttonRight;
    public int roundButton;
    public int time = R.id.time;

    @Test
    public void startButton() {

        onView(withId(time)).check(matches(withText("00:00")));
        onView(withId(startButton)).perform(click());

        try {
            Thread.sleep(1000);
            onView(withId(time)).check(matches(withText("00:01")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}