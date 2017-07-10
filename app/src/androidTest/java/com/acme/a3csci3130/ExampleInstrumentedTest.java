package com.acme.a3csci3130;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    /**
     * checks for create process
     */
    @Test
    public void create(){
        SystemClock.sleep(1000);
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.businessNumber)).perform(typeText("123456789"));
        onView(withId(R.id.name)).perform(typeText("Aqeb"));
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("Elm Street"));
        onView(withId(R.id.province)).perform(typeText("AB")).perform(closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
    }

    /**
     * checks for read process
     */
    @Test
    public void read(){
        SystemClock.sleep(1000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(1).perform(click());
    }

    /**
     * checks for update process
     */

    @Test
    public void update(){
        SystemClock.sleep(1000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * checks for delete process
     */
    @Test
    public void delete(){
        SystemClock.sleep(1000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
