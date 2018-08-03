package com.example.dave.programmerpuzzle.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.Application.Application;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
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

    private final String MAIN_TITLE = "Programmer Puzzle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Put this in a different thread or use AsyncSession in greenDAO.
        // For Demo purpose, this query is made on main thread but it should in a different thread.
        Puzzle puzzle = ((Application)getApplication()).getDaoSession().getPuzzleDao().load(1L);
        //((Application) getApplication()).getDaoSession().getPuzzleDao().loadAll();

        activityDesign();

    }

    private void activityDesign() {
        applicationTitle.setText(MAIN_TITLE);

        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_newgame) {
            Intent newGameIntent = new Intent(MainActivity.this, NewGameActivity.class);
            startActivity(newGameIntent);
            /*

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(newGameIntent);
                startActivity(newGameIntent);
            } else {
                startService(newGameIntent);
                startActivity(newGameIntent);
            }
             */

        } else if (id == R.id.nav_howtoplay) {
            Intent howToPlayIntent = new Intent(MainActivity.this, HowToPlayActivity.class);
            startActivity(howToPlayIntent);
        } else if (id == R.id.nav_highscore) {
            Intent highScoreIntent = new Intent(MainActivity.this, HighScoreActivity.class);
            startActivity(highScoreIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
