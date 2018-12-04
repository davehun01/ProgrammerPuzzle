package com.example.dave.programmerpuzzle.Activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.dave.programmerpuzzle.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class HowToPlayActivityTest extends ActivityInstrumentationTestCase2<HowToPlayActivity> {

    public HowToPlayActivityTest() {
        super(HowToPlayActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testTexts() {
        getActivity();
        onView(withId(R.id.howToPlayActivity_Text1))
                .check(matches(isDisplayed()));
        onView(withId(R.id.howToPlayActivity_Text2))
                .check(matches(isDisplayed()));
        onView(withId(R.id.howToPlayActivity_Text3))
                .check(matches(isDisplayed()));
        onView(withId(R.id.howToPlayActivity_Text1))
                .check(matches(withText(R.string.howToPlayActivity_Text1)));
        onView(withId(R.id.howToPlayActivity_Text2))
                .check(matches(withText(R.string.howToPlayActivity_Text2)));
        onView(withId(R.id.howToPlayActivity_Text3))
                .check(matches(withText(R.string.howToPlayActivity_Text3)));
    }

    @Test
    public void testImageButtons() {
        getActivity();
        onView(withId(R.id.howToPlayActivity_HintButton))
                .check(matches(isDisplayed()));
        onView(withId(R.id.howToPlayActivity_SkipButton))
                .check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
