package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.dave.programmerpuzzle.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    ArrayList<Integer> lines = new ArrayList<>();

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void fillLineList() {
        lines.add(R.id.newGameActivity_Line_1);lines.add(R.id.newGameActivity_Line_2);lines.add(R.id.newGameActivity_Line_3);
        lines.add(R.id.newGameActivity_Line_4);lines.add(R.id.newGameActivity_Line_5);lines.add(R.id.newGameActivity_Line_6);
        lines.add(R.id.newGameActivity_Line_7);lines.add(R.id.newGameActivity_Line_8);lines.add(R.id.newGameActivity_Line_9);
        lines.add(R.id.newGameActivity_Line_10);lines.add(R.id.newGameActivity_Line_11);lines.add(R.id.newGameActivity_Line_12);
        lines.add(R.id.newGameActivity_Line_13);lines.add(R.id.newGameActivity_Line_14);lines.add(R.id.newGameActivity_Line_15);
        lines.add(R.id.newGameActivity_Line_16);lines.add(R.id.newGameActivity_Line_17);lines.add(R.id.newGameActivity_Line_18);
        lines.add(R.id.newGameActivity_Line_19);lines.add(R.id.newGameActivity_Line_20);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        //intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            //intent.putExtra("language","C++");
            return intent;
        }
    };

    @Test
    public void testVisibilities() {
        getActivity();

        onView(withId(R.id.mainMenuActivity_applicationTitle))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNewGame() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_newgame));

        onView(withId(R.id.newgameActivity_RelLayout))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Hint))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_PuzzleDescription))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Skip))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Timer))
                .check(matches(isDisplayed()));

        onView(withId(R.id.newGameActivity_ScrollView))
                .perform(ViewActions.swipeUp());
        onView(withId(R.id.newGameActivity_Placeholder_20))
                .check(matches(isDisplayed()));

        /*
        onView(withId(R.id.newGameActivity_ScrollView))
                .perform(ViewActions.swipeDown());
        onView(withId(R.id.newGameActivity_Line_1))
                .check((isCompletelyBelow((withId(R.id.newGameActivity_PuzzleDescription)))));
        onView(withId(R.id.newGameActivity_Line_1))
                .perform(click());
        onView(withId(R.id.newGameActivity_ScrollView))
                .perform(ViewActions.swipeUp());
        onView(withId(R.id.newGameActivity_Line_1))
                .check((isCompletelyRightOf((withId(R.id.newGameActivity_Placeholder_1)))));
         */

        for (int i = 0; i < lines.size(); i++) {
            lines.get(i);

        }


    }

}
