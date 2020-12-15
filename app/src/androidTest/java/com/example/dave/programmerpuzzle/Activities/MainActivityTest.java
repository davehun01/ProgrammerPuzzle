package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
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
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            return new Intent();
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
    public void testNewGameVisibilities() {
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
    }

    @Test
    public void testNewGameBackPress() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_newgame));

        Espresso.pressBack();
        onView(withText(R.string.back_button_confirm))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.button2))
                .perform(ViewActions.click());

        Espresso.pressBack();
        onView(withText(R.string.back_button_confirm))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.button1))
                .perform(ViewActions.click());

        onView(withId(R.id.mainMenuActivity_applicationTitle))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNewGameHintButton() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_newgame));

        onView(withId(R.id.newGameActivity_Hint))
                .check(matches(isEnabled()));
        onView(withId(R.id.newGameActivity_Hint))
                .perform(ViewActions.click());
        onView(withId(R.id.newGameActivity_Hint))
                .check(matches(not(isEnabled())));
    }

    @Test
    public void testNewGameSkipButton() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_newgame));

        onView(withId(R.id.newGameActivity_Skip))
                .perform(ViewActions.click());
        onView(withText(R.string.skip_puzzle_confirm))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.button1))
                .perform(ViewActions.click());

        onView(withId(R.id.newgameActivity_RelLayout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNewGameGameFinished() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_newgame));

        for (int i = 0; i < 5; i++) {
            onView(withId(R.id.newGameActivity_Skip))
                    .perform(ViewActions.click());
            onView(withText(R.string.skip_puzzle_confirm))
                    .check(matches(isDisplayed()));
            onView(withId(android.R.id.button1))
                    .perform(ViewActions.click());
        }

        onView(withText("Game is finished. Your score is 0."))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.button1))
                .perform(ViewActions.click());

        onView(withId(R.id.mainMenuActivity_applicationTitle))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testOpenHowToPlay() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_howtoplay));

        onView(withId(R.id.howToPlayActivity_Text1))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testOpenHighScore() {
        getActivity();

        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen()));
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_highscore));

        onView(withId(R.id.score_Header))
                .check(matches(isDisplayed()));
        onView(withId(R.id.player_Header))
                .check(matches(isDisplayed()));
    }

}
