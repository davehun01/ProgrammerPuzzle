package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.dave.programmerpuzzle.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class HighScoreActivityTest extends ActivityInstrumentationTestCase2<HighScoreActivity> {

    public HighScoreActivityTest() {
        super(HighScoreActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Rule
    public IntentsTestRule<HighScoreActivity> mActivityRule = new IntentsTestRule<HighScoreActivity>(HighScoreActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            return new Intent();
        }
    };

    @Test
    public void testVisibilities() {
        getActivity();

        onView(withId(R.id.line_1_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_2_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_3_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_4_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_5_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_6_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_7_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_8_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_9_Player))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_10_Player))
                .check(matches(isDisplayed()));

        onView(withId(R.id.line_1_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_2_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_3_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_4_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_5_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_6_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_7_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_8_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_9_Score))
                .check(matches(isDisplayed()));
        onView(withId(R.id.line_10_Score))
                .check(matches(isDisplayed()));
    }

}