package com.scrum5bwi.timetrack;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.*;

import org.junit.*;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ControllingAdapter {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void startButton() {

        //onView(withId(startButton)).perform(click());
        //onView(withId(startButton)).check(matches(withText("00:00")));
    }
}