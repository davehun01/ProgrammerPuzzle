package com.example.dave.programmerpuzzle.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HighScoreActivity extends AppCompatActivity {

    @BindView(R.id.line_1_Player) TextView line_1_Player;
    @BindView(R.id.line_2_Player) TextView line_2_Player;
    @BindView(R.id.line_3_Player) TextView line_3_Player;
    @BindView(R.id.line_4_Player) TextView line_4_Player;
    @BindView(R.id.line_5_Player) TextView line_5_Player;
    @BindView(R.id.line_6_Player) TextView line_6_Player;
    @BindView(R.id.line_7_Player) TextView line_7_Player;
    @BindView(R.id.line_8_Player) TextView line_8_Player;
    @BindView(R.id.line_9_Player) TextView line_9_Player;
    @BindView(R.id.line_10_Player) TextView line_10_Player;

    @BindView(R.id.line_1_Score) TextView line_1_Score;
    @BindView(R.id.line_2_Score) TextView line_2_Score;
    @BindView(R.id.line_3_Score) TextView line_3_Score;
    @BindView(R.id.line_4_Score) TextView line_4_Score;
    @BindView(R.id.line_5_Score) TextView line_5_Score;
    @BindView(R.id.line_6_Score) TextView line_6_Score;
    @BindView(R.id.line_7_Score) TextView line_7_Score;
    @BindView(R.id.line_8_Score) TextView line_8_Score;
    @BindView(R.id.line_9_Score) TextView line_9_Score;
    @BindView(R.id.line_10_Score) TextView line_10_Score;

    private List<HighScore> highScores = new ArrayList<>();

    private ArrayList<TextView> players = new ArrayList<>();
    private ArrayList<TextView> scores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDesign();
    }

    private void activityDesign() {
        setContentView(R.layout.activity_high_score);

        ButterKnife.bind(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        fillPlayersList();

        fillScoresList();

        setTextStyles();

        getHighScores();

        setHighScoreTexts();
    }

    private void fillPlayersList() {
        players.add(line_1_Player); players.add(line_2_Player); players.add(line_3_Player);
        players.add(line_4_Player); players.add(line_5_Player); players.add(line_6_Player);
        players.add(line_7_Player); players.add(line_8_Player); players.add(line_9_Player);
        players.add(line_10_Player);
    }

    private void fillScoresList() {
        scores.add(line_1_Score); scores.add(line_2_Score); scores.add(line_3_Score);
        scores.add(line_4_Score); scores.add(line_5_Score); scores.add(line_6_Score);
        scores.add(line_7_Score); scores.add(line_8_Score); scores.add(line_9_Score);
        scores.add(line_10_Score);
    }

    private void setTextStyles() {
        for (TextView textView : players) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,24.0f);
            textView.setTextColor(getResources().getColor(R.color.colorWhite));
        }
        for (TextView textView : scores) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,24.0f);
            textView.setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    private void getHighScores() {
        highScores = MainApplication.getInstance().getDataCache().getHighScoreList();
        Collections.sort(highScores);
    }

    private void setHighScoreTexts() {
        for (int i = 0; i < 10 && i < highScores.size(); i++) {
            players.get(i).setText((i + 1) + ". " + highScores.get(i).getPlayer());
            scores.get(i).setText(String.valueOf(highScores.get(i).getPoints()));
        }
    }
}
