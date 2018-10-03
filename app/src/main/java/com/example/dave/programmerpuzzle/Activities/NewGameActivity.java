package com.example.dave.programmerpuzzle.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.util.TypedValue;
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
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewGameActivity extends AppCompatActivity implements GameLogicInterface {

    @BindView(R.id.newGameActivity_PuzzleDescription) TextView puzzleDescription;
    @BindView(R.id.newGameActivity_Line_1) PuzzleButton line_1;
    @BindView(R.id.newGameActivity_Line_2) PuzzleButton line_2;
    @BindView(R.id.newGameActivity_Line_3) PuzzleButton line_3;
    @BindView(R.id.newGameActivity_Line_4) PuzzleButton line_4;
    @BindView(R.id.newGameActivity_Line_5) PuzzleButton line_5;
    @BindView(R.id.newGameActivity_Line_6) PuzzleButton line_6;
    @BindView(R.id.newGameActivity_Line_7) PuzzleButton line_7;
    @BindView(R.id.newGameActivity_Line_8) PuzzleButton line_8;
    @BindView(R.id.newGameActivity_Line_9) PuzzleButton line_9;
    @BindView(R.id.newGameActivity_Line_10) PuzzleButton line_10;
    @BindView(R.id.newGameActivity_Line_11) PuzzleButton line_11;
    @BindView(R.id.newGameActivity_Line_12) PuzzleButton line_12;
    @BindView(R.id.newGameActivity_Line_13) PuzzleButton line_13;
    @BindView(R.id.newGameActivity_Line_14) PuzzleButton line_14;
    @BindView(R.id.newGameActivity_Line_15) PuzzleButton line_15;
    @BindView(R.id.newGameActivity_Line_16) PuzzleButton line_16;
    @BindView(R.id.newGameActivity_Line_17) PuzzleButton line_17;
    @BindView(R.id.newGameActivity_Line_18) PuzzleButton line_18;
    @BindView(R.id.newGameActivity_Line_19) PuzzleButton line_19;
    @BindView(R.id.newGameActivity_Line_20) PuzzleButton line_20;

    @BindView(R.id.newGameActivity_Placeholder_1) Button placeholder_1;
    @BindView(R.id.newGameActivity_Placeholder_2) Button placeholder_2;
    @BindView(R.id.newGameActivity_Placeholder_3) Button placeholder_3;
    @BindView(R.id.newGameActivity_Placeholder_4) Button placeholder_4;
    @BindView(R.id.newGameActivity_Placeholder_5) Button placeholder_5;
    @BindView(R.id.newGameActivity_Placeholder_6) Button placeholder_6;
    @BindView(R.id.newGameActivity_Placeholder_7) Button placeholder_7;
    @BindView(R.id.newGameActivity_Placeholder_8) Button placeholder_8;
    @BindView(R.id.newGameActivity_Placeholder_9) Button placeholder_9;
    @BindView(R.id.newGameActivity_Placeholder_10) Button placeholder_10;
    @BindView(R.id.newGameActivity_Placeholder_11) Button placeholder_11;
    @BindView(R.id.newGameActivity_Placeholder_12) Button placeholder_12;
    @BindView(R.id.newGameActivity_Placeholder_13) Button placeholder_13;
    @BindView(R.id.newGameActivity_Placeholder_14) Button placeholder_14;
    @BindView(R.id.newGameActivity_Placeholder_15) Button placeholder_15;
    @BindView(R.id.newGameActivity_Placeholder_16) Button placeholder_16;
    @BindView(R.id.newGameActivity_Placeholder_17) Button placeholder_17;
    @BindView(R.id.newGameActivity_Placeholder_18) Button placeholder_18;
    @BindView(R.id.newGameActivity_Placeholder_19) Button placeholder_19;
    @BindView(R.id.newGameActivity_Placeholder_20) Button placeholder_20;

    @BindView(R.id.newgameActivity_RelLayout) ViewGroup viewGroup;

    @BindView(R.id.newGameActivity_Timer) TextView timer;

    @BindView(R.id.newGameActivity_Hint) ImageButton hintButton;

    @BindView(R.id.newGameActivity_Skip) ImageButton skipButton;

    private int puzzleCount = 0;

    private String language = "";

    private static int CURRENT_LINE = 0;

    private static String CURRENT_STARTING_SPACE = "";

    private long timeLeftSec;

    private static int PUZZLES_IN_ONE_GAME = 5;

    private List<PuzzleButton> lines = new ArrayList<>();

    private List<Button> placeholders = new ArrayList<>();

    private List<Integer> usedPlaceholders = new ArrayList<>();

    private List<PuzzleButton> usedLines = new ArrayList<>();

    private GameLogic gameLogic;

    private MediaPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDesign();

        loadSettings();

        gameLogic = new GameLogic(this,
                MainApplication.getInstance().getDataCache().getPuzzleList(language));

        fillLineList();

        fillPlaceHoldersList();

        setPlaceHoldersText();

        removeButtonDependencies();

        setOnTouchListeners();

        gameLogic.newPuzzle();
    }

    private void activityDesign() {
        setContentView(R.layout.activity_new_game);

        ButterKnife.bind(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        timer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f);
    }

    private void loadSettings() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        language = sharedPreferences.getString("key_language", "C++");

        /*
        if (sharedPreferences.getBoolean("key_sound",false) == true) {
            soundPlayer = new MediaPlayer();
        }
         */

    }

    private void fillLineList() {
        lines.add(line_1);lines.add(line_2);lines.add(line_3);lines.add(line_4);lines.add(line_5);
        lines.add(line_6);lines.add(line_7);lines.add(line_8);lines.add(line_9);lines.add(line_10);
        lines.add(line_11);lines.add(line_12);lines.add(line_13);lines.add(line_14);lines.add(line_15);
        lines.add(line_16);lines.add(line_17);lines.add(line_18);lines.add(line_19);lines.add(line_20);
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
                for (int i = 0; i < lines.size(); i++) {
                    lines.get(i).setOriginalX(Math.round(lines.get(i).getX()));
                    lines.get(i).setOriginalY(Math.round(lines.get(i).getY()));
                    setXY(lines.get(i));
                }
                setXY(placeholder_1);
            }
        });
    }

    private void setXY(Button button) {
        RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.leftMargin = Math.round(button.getX());
        newPositionParams.topMargin = Math.round(button.getY());
        button.setLayoutParams(newPositionParams);
    }

    private void setOnTouchListeners() {
        linesOnTouchListeners();

        hintButtonOnTouchListener();

        skipButtonOnTouchListener();
    }

    private void linesOnTouchListeners() {
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
    }

    private void hintButtonOnTouchListener() {
        hintButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    for (int i = 0; i < lines.size(); i++) {
                        if (lines.get(i).getCorrectLines() == null) continue;
                        int nextFreeLine = -1;
                        for (int j = 0; j < 20; j++) {
                            if (!usedPlaceholders.contains(j)) {
                                nextFreeLine = j;
                                break;
                            }
                        }
                        if (lines.get(i).getCorrectLines().contains(nextFreeLine) && !usedLines.contains(lines.get(i))) {
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

    private void skipButtonOnTouchListener() {
        skipButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(NewGameActivity.this);

                    builder.setMessage(R.string.skip_puzzle_confirm);

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            gameLogic.newPuzzle();
                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alert = builder.create();
                    if(!(NewGameActivity.this).isFinishing()) {
                        alert.show();
                    }
                }
                return true;
            }
        });
    }

    private void moveButton(View view, int j) {
        for (int i = 0; i < 20; i++) {
            if (!usedPlaceholders.contains(i)) {
                CURRENT_LINE = i;
                usedPlaceholders.add(i);
                break;
            }
        }
        TransitionManager.beginDelayedTransition(viewGroup);
        RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.addRule(RelativeLayout.END_OF, placeholders.get(CURRENT_LINE).getId());
        newPositionParams.addRule(RelativeLayout.ALIGN_BASELINE, placeholders.get(CURRENT_LINE).getId());
        view.setLayoutParams(newPositionParams);

        lines.get(j).setActualLine(CURRENT_LINE);
        usedLines.add(lines.get(j));

        if (!language.equals("Python")) setSpacing();

        refreshListeners();

        checkPuzzleDone();
    }

    private void moveFixedButton(View view, int j, int place) {
        TransitionManager.beginDelayedTransition(viewGroup);
        RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.addRule(RelativeLayout.END_OF, placeholders.get(place).getId());
        newPositionParams.addRule(RelativeLayout.ALIGN_BASELINE, placeholders.get(place).getId());
        view.setLayoutParams(newPositionParams);
        ((PuzzleButton) view).setActualLine(place);
        view.setEnabled(false);
        usedPlaceholders.add(place);
        usedLines.add(lines.get(j));
    }

    private void moveButtonBack(View view) {
        TransitionManager.beginDelayedTransition(viewGroup);
        RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.leftMargin = ((PuzzleButton) view).getOriginalX();
        newPositionParams.topMargin = ((PuzzleButton) view).getOriginalY();
        view.setLayoutParams(newPositionParams);

        if (!language.equals("Python")) ((PuzzleButton) view).setText(((PuzzleButton) view).getText().toString().trim());

        if (!usedPlaceholders.isEmpty()) {
            usedPlaceholders.remove((Integer) ((PuzzleButton) view).getActualLine());
        }

        ((PuzzleButton) view).setActualLine(-1);

        usedLines.remove(view);

        if (!language.equals("Python")) setSpacing();

        refreshListeners();
    }

    private void setSpacing() {
        Collections.sort(usedLines);
        CURRENT_STARTING_SPACE = "";
        for (PuzzleButton puzzleButton : usedLines) {
            puzzleButton.setText(puzzleButton.getText().toString().trim());

            if (puzzleButton.getText().toString().contains("}") && CURRENT_STARTING_SPACE.length() >= 4) {
                CURRENT_STARTING_SPACE = CURRENT_STARTING_SPACE.substring(4);
            }

            puzzleButton.setText(CURRENT_STARTING_SPACE + puzzleButton.getText());

            if (puzzleButton.getText().toString().contains("{")) {
                CURRENT_STARTING_SPACE += "    ";
            }
        }
    }

    private void refreshListeners() {
        linesOnTouchListeners();

        for (PuzzleButton puzzleButton : usedLines) {
            puzzleButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        moveButtonBack(view);
                    }
                    return true;
                }
            });
        }
    }

    private void disableEmptyButtons() {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getText() == null || lines.get(i).getText().equals("")) {
                lines.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }

    private void moveFixedLines() {
        puzzleDescription.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < lines.size(); i++) {
                    if (!(lines.get(i).getText().equals("") || lines.get(i) == null)) {
                        if (lines.get(i).getCorrectLines().get(0) < 0) {
                            moveFixedButton(lines.get(i), i, lines.get(i).getCorrectLines().get(0) * (-1) - 2);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void showPuzzle(Puzzle puzzle) {
        if (puzzleCount == PUZZLES_IN_ONE_GAME) {
            gameEnd();
            return;
        }
        int heightDiff = puzzleDescription.getHeight();
        final int[] widthDifferences = new int[10];
        for (int i = 0; i < 10; i++) {
            widthDifferences[i] = lines.get(i).getWidth();
        }

        puzzleDescription.setText(puzzle.getDescription());

        if (puzzleCount != 0) {
            for (PuzzleButton puzzleButton : lines) puzzleButton.setText("");
        }

        String[] puzzleLines = puzzle.getCode().split("\\r?\\n");
        if (!puzzle.getLanguage().equals("Python")) {
            tokenizeCode(puzzleLines, false);
        } else {
            tokenizeCode(puzzleLines, true);
        }

        if (puzzleCount != 0) {
            resetButtons(heightDiff, widthDifferences);
            setOnTouchListeners();
            gameLogic.end();
        }

        restartState();

        if (puzzleCount == 0) {
            disableEmptyButtons();

            moveFixedLines();
        }

        puzzleCount++;
    }

    private void resetButtons(final int heightDiff, final int[] widthDifferences) {
        final boolean[] movedFixedLines = {false};

        for (int i = 0; i < lines.size(); i++) {
            final int j = i;
            lines.get(j).post(new Runnable() {
                @Override
                public void run() {
                    int heightDifference = heightDiff - puzzleDescription.getHeight();
                    lines.get(j).setOriginalY(lines.get(j).getOriginalY() - heightDifference);

                    if (j < 10) {
                        widthDifferences[j] -= lines.get(j).getWidth();
                    } else {
                        lines.get(j).setOriginalX(lines.get(j).getOriginalX() - widthDifferences[j - 10]);
                    }

                    moveButtonBack(lines.get(j));
                    lines.get(j).setVisibility(View.VISIBLE);
                    if (!movedFixedLines[0]) {
                        disableEmptyButtons();
                        moveFixedLines();
                        movedFixedLines[0] = true;
                    }
                }
            });
        }

        placeholder_1.post(new Runnable() {
            @Override
            public void run() {
                int heightDifference = heightDiff - puzzleDescription.getHeight();
                RelativeLayout.LayoutParams newPositionParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                newPositionParams.leftMargin = Math.round(placeholder_1.getX());
                newPositionParams.topMargin = Math.round(placeholder_1.getY() - heightDifference);
                placeholder_1.setLayoutParams(newPositionParams);
            }
        });

    }

    private void restartState() {
        CURRENT_LINE = 0;
        usedPlaceholders.clear();
        usedLines.clear();
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
                lines.get(i + j).setText(lineSplit[0]);
            } else {
                lineSplit = puzzleLines[i].split("//");
                lines.get(i + j).setText(lineSplit[0].trim());
            }

            String[] lineNumbers = lineSplit[1].split(",");
            ArrayList<Integer> correctLines = new ArrayList<>();
            for (String line : lineNumbers) {
                correctLines.add(Integer.valueOf(line) - 1);
            }
            lines.get(i + j).setCorrectLines(correctLines);
        }
    }

    private void checkPuzzleDone() {
        boolean puzzleDone = true;
        for (PuzzleButton puzzleButton : lines) {
            if (puzzleButton.getCorrectLines() != null && !puzzleButton.getText().toString().equals("")) {
                if (!puzzleButton.getCorrectLines().contains(puzzleButton.getActualLine())) {
                    puzzleDone = false;
                }
            }
        }
        if (puzzleDone) {
            gameLogic.addScore(timeLeftSec);
            showPuzzleDoneDialog();
        }
    }

    private void showPuzzleDoneDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Well done!")
                .setCancelable(false)
                .setPositiveButton("Go next!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        gameLogic.newPuzzle();
                    }
                });
        AlertDialog alert = builder.create();
        if(!(NewGameActivity.this).isFinishing()) {
            alert.show();
        }
    }

    @Override
    public void timeExpired() {
        showTimeExpiredDialog();
    }

    private void showTimeExpiredDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Time expired.")
                .setCancelable(false)
                .setPositiveButton("Go next!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        gameLogic.newPuzzle();
                    }
                });
        AlertDialog alert = builder.create();
        if(!(NewGameActivity.this).isFinishing()) {
            alert.show();
        }
    }

    @Override
    public void gameEnd() {
        gameLogic.end();
        showGameEndDialog();
    }

    private void showGameEndDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Game is finished. Your score is " + gameLogic.getScore() + ".")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //TODO:
                        //saveHighScore();
                        Intent mainMenuIntent = new Intent(NewGameActivity.this, MainActivity.class);
                        startActivity(mainMenuIntent);
                    }
                });
        AlertDialog alert = builder.create();
        if(!(NewGameActivity.this).isFinishing()) {
            alert.show();
        }
    }

    @Override
    public void showTimer(long timeLeft) {
        long timeLeftSec = timeLeft / 1000;
        this.timeLeftSec = timeLeftSec;
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(NewGameActivity.this);

        builder.setMessage(R.string.back_button_confirm);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        if(!(NewGameActivity.this).isFinishing()) {
            alert.show();
        }
    }
}
