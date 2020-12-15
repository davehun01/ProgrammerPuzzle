package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.GameLogic.GameLogic;
import com.example.dave.programmerpuzzle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.mainMenuActivity_applicationTitle)
    TextView applicationTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    public static int PUZZLES_IN_ONE_GAME = 5;

    public static int PUZZLE_COUNT = 0;

    private String language = "";

    private static GameLogic gameLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        activityDesign();
    }

    private void activityDesign() {
        applicationTitle.setText(R.string.app_name);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_newgame:
                startNewGame();
                break;
            case R.id.nav_howtoplay:
                Intent howToPlayIntent = new Intent(MainActivity.this, HowToPlayActivity.class);
                startActivity(howToPlayIntent);
                break;
            case R.id.nav_highscore:
                Intent highScoreIntent = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(highScoreIntent);
                break;
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startNewGame() {
        PUZZLE_COUNT = 0;
        loadSettings();

        gameLogic = new GameLogic(MainApplication.getInstance().getDataCache().getPuzzleList(language));

        Intent newGameIntent = new Intent(MainActivity.this, NewGameActivity.class);
        newGameIntent.putExtra("language", language);
        startActivity(newGameIntent);
    }

    private void loadSettings() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        language = sharedPreferences.getString("key_language", "C++");
    }

    public static GameLogic getGameLogic() {
        return gameLogic;
    }

}
