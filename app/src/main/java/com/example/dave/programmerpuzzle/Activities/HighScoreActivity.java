package com.example.dave.programmerpuzzle.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.programmerpuzzle.R;

import butterknife.ButterKnife;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        ButterKnife.bind(this);
    }
}
