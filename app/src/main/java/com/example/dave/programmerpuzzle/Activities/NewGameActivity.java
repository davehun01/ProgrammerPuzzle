package com.example.dave.programmerpuzzle.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.GameLogic.GameLogic;
import com.example.dave.programmerpuzzle.GameLogic.GameLogicInterface;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.R;
import com.example.dave.programmerpuzzle.View.PuzzleButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewGameActivity extends AppCompatActivity implements GameLogicInterface {

    @BindView(R.id.newGameActivity_PuzzleDescription)
    TextView puzzleDescription;
    @BindView(R.id.newGameActivity_Line_1)
    PuzzleButton line_1;
    @BindView(R.id.newGameActivity_Line_2)
    PuzzleButton line_2;
    @BindView(R.id.newGameActivity_Line_3)
    PuzzleButton line_3;
    @BindView(R.id.newGameActivity_Line_4)
    PuzzleButton line_4;
    @BindView(R.id.newGameActivity_Line_5)
    PuzzleButton line_5;
    @BindView(R.id.newGameActivity_Line_6)
    PuzzleButton line_6;
    @BindView(R.id.newGameActivity_Line_7)
    PuzzleButton line_7;
    @BindView(R.id.newGameActivity_Line_8)
    PuzzleButton line_8;
    @BindView(R.id.newGameActivity_Line_9)
    PuzzleButton line_9;
    @BindView(R.id.newGameActivity_Line_10)
    PuzzleButton line_10;
    @BindView(R.id.newGameActivity_Line_11)
    PuzzleButton line_11;
    @BindView(R.id.newGameActivity_Line_12)
    PuzzleButton line_12;
    @BindView(R.id.newGameActivity_Line_13)
    PuzzleButton line_13;
    @BindView(R.id.newGameActivity_Line_14)
    PuzzleButton line_14;
    @BindView(R.id.newGameActivity_Line_15)
    PuzzleButton line_15;
    @BindView(R.id.newGameActivity_Line_16)
    PuzzleButton line_16;
    @BindView(R.id.newGameActivity_Line_17)
    PuzzleButton line_17;
    @BindView(R.id.newGameActivity_Line_18)
    PuzzleButton line_18;
    @BindView(R.id.newGameActivity_Line_19)
    PuzzleButton line_19;
    @BindView(R.id.newGameActivity_Line_20)
    PuzzleButton line_20;

    private List<PuzzleButton> lines = new ArrayList<>();

    private GameLogic gameLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        ButterKnife.bind(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        gameLogic = new GameLogic(this,
                MainApplication.getInstance().getDataCache().getPuzzleList());

        fillLineList();

        puzzleDescription.setText("Test description. Test description. " +
                "Test description. Test description. Test description." +
                " Test description. Test description. Test description. " +
                "Test description. Test description. Test description. " +
                "Test description. Test description.");

        line_1.setText("public int average(List<Integer> numbers) {");
        line_2.setText("for (int i = 0; i < numbers.size(); i++) {");
        line_3.setText("System.out.println('null reference!');");
        line_4.setText("int average = sum / numbers.size();");
        line_5.setText("System.out.println('Empty list');");
        line_6.setText("if (numbers.isEmpty()) {");
        line_7.setText("sum += numbers.get(i);");
        line_8.setText("if (numbers == null) {");
        line_9.setText("return average;");
        line_10.setText("int sum = 0;");
        line_11.setText("}");
        line_12.setText("}");
        line_13.setText("}");
        line_14.setText("}");
        line_15.setText("return -1;");
        line_16.setText("return -1;");

    }

    private void fillLineList() {
        lines.add(line_1);lines.add(line_2);lines.add(line_3);lines.add(line_4);
        lines.add(line_5);lines.add(line_6);lines.add(line_7);lines.add(line_8);
        lines.add(line_9);lines.add(line_10);lines.add(line_11);lines.add(line_12);
        lines.add(line_13);lines.add(line_14);lines.add(line_15);lines.add(line_16);
        lines.add(line_17);lines.add(line_18);lines.add(line_19);lines.add(line_20);
    }

    @Override
    public void showPuzzle(Puzzle puzzle) {
        puzzleDescription.setText(puzzle.getDescription());
        //etc
    }

    @Override
    public void timeExpired() {

    }

    @Override
    public void gameEnd() {

    }

    @Override
    public void showTimer(long timeLeft) {

    }

    @Override
    public void setButtonsEnability(boolean enabled) {

    }
}
