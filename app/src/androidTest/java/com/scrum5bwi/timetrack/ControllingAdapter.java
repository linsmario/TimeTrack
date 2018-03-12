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
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.util.Log.d;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class ControllingAdapter {

    public int stopButton = R.id.buttonLeft;
    public int startButton = R.id.buttonRight;
    public int pauseButton = R.id.buttonRight;
    public int roundButton;
    public int time = R.id.Time;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void start_shouldStartTimer_whenButtonPressed() {

        Log.d("EMRE:", "test");
        onView(withId(pauseButton)).perform(click());
        Log.d("EMRE:", "test 2");
        //try {
        onView(withId(startButton)).perform(click());
        /*} catch () {
            Log.d("fail", "fail");
            e.printStackTrace();
        }*/
    }

    public void stop_shouldStopTimer_whenButtonPressed() {

        TextView timeView = (TextView) activityTestRule.getActivity().findViewById(pauseButton);
        String startTime = (String) timeView.getText();

        onView(withId(pauseButton)).perform(click());

        try {
            Thread.sleep(1000);
            onView(withId(time)).check(matches(withText(startTime)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}