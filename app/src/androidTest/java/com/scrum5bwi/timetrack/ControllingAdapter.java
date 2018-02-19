package com.scrum5bwi.timetrack;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.*;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;
import android.util.Log;
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
    public int time = R.id.Time;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void start_stop_Button() {

        onView(withId(time)).check(matches(withText("00:00:00")));
        onView(withId(startButton)).perform(click());

        try {
            Thread.sleep(1000);
            onView(withId(time)).check(matches(withText("00:00:00")));

            onView(withId(stopButton)).perform(click());
            Thread.sleep(1000);
            onView(withId(time)).check(matches(withText("00:00:00")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}