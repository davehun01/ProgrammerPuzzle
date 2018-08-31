package com.example.dave.programmerpuzzle.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.GameLogic.GameLogic;
import com.example.dave.programmerpuzzle.GameLogic.GameLogicInterface;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.R;
import com.example.dave.programmerpuzzle.View.PuzzleButton;

import java.util.ArrayList;
import java.util.Arrays;
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

    @BindView(R.id.newGameActivity_Placeholder_1)
    Button placeholder_1;
    @BindView(R.id.newGameActivity_Placeholder_2)
    Button placeholder_2;
    @BindView(R.id.newGameActivity_Placeholder_3)
    Button placeholder_3;
    @BindView(R.id.newGameActivity_Placeholder_4)
    Button placeholder_4;
    @BindView(R.id.newGameActivity_Placeholder_5)
    Button placeholder_5;
    @BindView(R.id.newGameActivity_Placeholder_6)
    Button placeholder_6;
    @BindView(R.id.newGameActivity_Placeholder_7)
    Button placeholder_7;
    @BindView(R.id.newGameActivity_Placeholder_8)
    Button placeholder_8;
    @BindView(R.id.newGameActivity_Placeholder_9)
    Button placeholder_9;
    @BindView(R.id.newGameActivity_Placeholder_10)
    Button placeholder_10;
    @BindView(R.id.newGameActivity_Placeholder_11)
    Button placeholder_11;
    @BindView(R.id.newGameActivity_Placeholder_12)
    Button placeholder_12;
    @BindView(R.id.newGameActivity_Placeholder_13)
    Button placeholder_13;
    @BindView(R.id.newGameActivity_Placeholder_14)
    Button placeholder_14;
    @BindView(R.id.newGameActivity_Placeholder_15)
    Button placeholder_15;
    @BindView(R.id.newGameActivity_Placeholder_16)
    Button placeholder_16;
    @BindView(R.id.newGameActivity_Placeholder_17)
    Button placeholder_17;
    @BindView(R.id.newGameActivity_Placeholder_18)
    Button placeholder_18;
    @BindView(R.id.newGameActivity_Placeholder_19)
    Button placeholder_19;
    @BindView(R.id.newGameActivity_Placeholder_20)
    Button placeholder_20;

    @BindView(R.id.newgameActivity_RelLayout)
    ViewGroup viewGroup;

    @BindView(R.id.newGameActivity_Timer)
    TextView timer;

    @BindView(R.id.newGameActivity_Hint)
    ImageButton hintButton;

    private static int CURRENT_LINE = 0;

    private static String CURRENT_STARTING_SPACE = "";

    private List<PuzzleButton> lines = new ArrayList<>();

    private List<Button> placeholders = new ArrayList<>();

    private List<PuzzleButton> usedLines = new ArrayList<>();

    private GameLogic gameLogic;

    private MediaPlayer soundPlayer;

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        ButterKnife.bind(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        gameLogic = new GameLogic(this,
                MainApplication.getInstance().getDataCache().getPuzzleList());

        /*
        soundplayer:
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        if (sharedPreferences.getBoolean("key_sound",false) == true) {
            soundPlayer = new MediaPlayer();
        }
         */

        fillLineList();

        fillPlaceHoldersList();

        setPlaceHoldersText();

        removeButtonDependencies();

        setOnTouchListeners();

        gameLogic.newPuzzle();

        disableEmptyButtons();

    }

    private void fillLineList() {
        lines.add(line_1);lines.add(line_2);lines.add(line_3);lines.add(line_4);
        lines.add(line_5);lines.add(line_6);lines.add(line_7);lines.add(line_8);
        lines.add(line_9);lines.add(line_10);lines.add(line_11);lines.add(line_12);
        lines.add(line_13);lines.add(line_14);lines.add(line_15);lines.add(line_16);
        lines.add(line_17);lines.add(line_18);lines.add(line_19);lines.add(line_20);
    }

    private void fillPlaceHoldersList() {
        placeholders.add(placeholder_1);placeholders.add(placeholder_2);placeholders.add(placeholder_3);
        placeholders.add(placeholder_4);placeholders.add(placeholder_5);placeholders.add(placeholder_6);
        placeholders.add(placeholder_7);placeholders.add(placeholder_8);placeholders.add(placeholder_9);
        placeholders.add(placeholder_10);placeholders.add(placeholder_11);placeholders.add(placeholder_12);
        placeholders.add(placeholder_13);placeholders.add(placeholder_14);placeholders.add(placeholder_15);
        placeholders.add(placeholder_16);placeholders.add(placeholder_17);placeholders.add(placeholder_18);
        placeholders.add(placeholder_19);placeholders.add(placeholder_20);
    }

    private void setPlaceHoldersText() {
        for (int i = 1; i <= 9; i++) placeholders.get(i-1).setText("  " + i);
        for (int i = 10; i <= 20; i++) placeholders.get(i-1).setText("" + i);
    }

    private void removeButtonDependencies() {
        puzzleDescription.post(new Runnable() {
            @Override
            public void run() {
                int[] coords = new int[2];
                for (int i = 0; i < lines.size(); i++) {
                    lines.get(i).getLocationOnScreen(coords);
                    RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    newPositionParams.leftMargin = Math.round(lines.get(i).getX());
                    newPositionParams.topMargin = Math.round(lines.get(i).getY());
                    lines.get(i).setLayoutParams(newPositionParams);
                }
                placeholder_1.getLocationOnScreen(coords);
                RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                newPositionParams.leftMargin = Math.round(placeholder_1.getX());
                newPositionParams.topMargin = Math.round(placeholder_1.getY());
                placeholder_1.setLayoutParams(newPositionParams);
            }
        });
    }

    private void setOnTouchListeners() {

        for (int i = 0; i < lines.size(); i++) {
            final int j = i;
            lines.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        moveButton(view, j);
                    }
                    return true;
                }
            });
        }

        hintButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    for (int i = 0; i < lines.size(); i++) {
                        if (lines.get(i).getCorrectLines() == null) continue;
                        if (lines.get(i).getCorrectLines().contains(CURRENT_LINE+1)) {
                            moveButton(lines.get(i), i);
                            hintButton.setImageResource(R.mipmap.ic_hint_used_transparent);
                            hintButton.setEnabled(false);
                            break;
                        }
                    }
                }
                return true;
            }
        });
    }

    private void moveButton(View view, int j) {
        TransitionManager.beginDelayedTransition(viewGroup);
        RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.addRule(RelativeLayout.END_OF, placeholders.get(CURRENT_LINE).getId());
        newPositionParams.addRule(RelativeLayout.ALIGN_BASELINE, placeholders.get(CURRENT_LINE).getId());
        view.setLayoutParams(newPositionParams);
        if (lines.get(j).getText().toString().contains("}")) CURRENT_STARTING_SPACE = CURRENT_STARTING_SPACE.substring(4);
        lines.get(j).setText(CURRENT_STARTING_SPACE + lines.get(j).getText());
        if (lines.get(j).getText().toString().contains("{")) CURRENT_STARTING_SPACE += "    ";
        CURRENT_LINE++;
        usedLines.add(lines.get(j));
        //lines.remove(j);
    }

    private void disableEmptyButtons() {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getText() == null || lines.get(i).getText().equals("")) {
                lines.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void showPuzzle(Puzzle puzzle) {
        puzzleDescription.setText(puzzle.getDescription());
        String[] puzzleLines = puzzle.getCode().split("\\r?\\n");
        if (!puzzle.getLanguage().equals("Python")) {
            for (int i = 0; i < puzzleLines.length; i++) puzzleLines[i] = puzzleLines[i].trim();
            tokenizeCode(puzzleLines, false);
        } else {
            tokenizeCode(puzzleLines, true);
        }
        restartState();
    }

    private void restartState() {
        CURRENT_LINE = 0;
        CURRENT_STARTING_SPACE = "";
        hintButton.setImageResource(R.mipmap.ic_hint_transparent);
        setButtonsEnability(true);
    }

    private void tokenizeCode(String[] puzzleLines, boolean languagePython) {
        Arrays.sort(puzzleLines, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        if (puzzleLines.length < 11) {
            setLineTexts(puzzleLines, 0, languagePython);
        } else {
            String[] firstHalf = new String[10];
            System.arraycopy(puzzleLines, 0, firstHalf, 0, 10);
            String[] secondHalf = new String[puzzleLines.length - 10];
            System.arraycopy(puzzleLines, 10, secondHalf, 0, puzzleLines.length - 10);
            setLineTexts(firstHalf, 0, languagePython);

            Arrays.sort(secondHalf, new java.util.Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();
                }
            });

            setLineTexts(secondHalf, 10, languagePython);
        }
    }
    
    private void setLineTexts(String[] puzzleLines, int j, boolean languagePython) {
        for (int i = 0; i < puzzleLines.length; i++) {
            String[] lineSplit;
            if (languagePython) {
                lineSplit = puzzleLines[i].split("#");
            } else {
                lineSplit = puzzleLines[i].split("//");
            }
            lines.get(i + j).setText(lineSplit[0]);
            String[] lineNumbers = lineSplit[1].split("\\,");
            ArrayList<Integer> correctLines = new ArrayList<>();
            for (String line : lineNumbers) {
                correctLines.add(Integer.valueOf(line));
            }
            lines.get(i + j).setCorrectLines(correctLines);
        }
    }

    @Override
    public void timeExpired() {

    }

    @Override
    public void gameEnd() {

    }

    @Override
    public void showTimer(long timeLeft) {
        long timeLeftSec = timeLeft / 1000;
        long minutes = timeLeftSec / 60;
        long seconds = timeLeftSec - minutes * 60;
        if (seconds >= 10) {
            timer.setText(minutes + ":" + seconds);
        } else {
            timer.setText(minutes + ":0" + seconds);
        }

    }

    @Override
    public void setButtonsEnability(boolean enabled) {
        for (PuzzleButton puzzleButton : lines) {
            puzzleButton.setEnabled(enabled);
        }
        hintButton.setEnabled(enabled);
    }
}
