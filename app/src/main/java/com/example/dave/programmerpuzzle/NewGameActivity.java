package com.example.dave.programmerpuzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewGameActivity extends AppCompatActivity {

    @BindView(R.id.newGameActivity_PuzzleDescription)
    TextView puzzleDescription;

    @BindView(R.id.newGameActivity_Line_1)
    TextView line1;

    @BindView(R.id.newGameActivity_Line_2)
    TextView line2;

    @BindView(R.id.newGameActivity_Line_3)
    TextView line3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        ButterKnife.bind(this);

        puzzleDescription.setText("Test description. Test description. " +
                "Test description. Test description. Test description." +
                " Test description. Test description. Test description. " +
                "Test description. Test description. Test description. " +
                "Test description. Test description.");

        line1.setText("First line");
        line2.setText("Second line");
        //line2.setText("Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\n Second line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\nSecond line\n");

    }
}
