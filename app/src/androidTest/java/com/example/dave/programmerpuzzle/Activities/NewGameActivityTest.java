package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NewGameActivityTest extends ActivityInstrumentationTestCase2<NewGameActivity> {

    private MainActivity mainActivity;

    public NewGameActivityTest() {
        super(NewGameActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        //super.setUp();
        //injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        //intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
        ArrayList<Puzzle> list = new ArrayList<>();
        //GameLogic gameLogic = new GameLogic(list);
        Intents.init();

        mainActivity = new MainActivity();
    }

    @Rule
    public IntentsTestRule<NewGameActivity> mActivityRule = new IntentsTestRule<NewGameActivity>(NewGameActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            intent.putExtra("language","C++");
            return intent;
        }
    };

    @Test
    public void testVisibilities() {
        getActivity();
        onView(withId(R.id.newgameActivity_RelLayout))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Hint))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_PuzzleDescription))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_SeparatorLine))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Skip))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Timer))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_1))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_2))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_3))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_4))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_5))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_6))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_7))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_8))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_9))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_10))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_11))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_12))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_13))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_14))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_15))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_16))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_17))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_18))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_19))
                .check(matches(isDisplayed()));
        onView(withId(R.id.newGameActivity_Placeholder_20))
                .check(matches(isDisplayed()));
    }

    @Test
    public void test() {

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
