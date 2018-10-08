package com.example.dave.programmerpuzzle.GameLogic;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.dave.programmerpuzzle.Activities.MainActivity;
import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.Tools.GameTimer;
import com.example.dave.programmerpuzzle.Tools.GameTimerInterface;
import com.example.dave.programmerpuzzle.Tools.VibratorEngine;

import java.util.List;
import java.util.Random;

public class GameLogic implements GameTimerInterface {

    private NewGameInterface newGameInterface;

    private List<Puzzle> puzzleList;

    private Puzzle currentPuzzle;

    private long score;

    private GameTimer gameTimer;

    private static final int SECONDS_FOR_PUZZLE = 720;

    public GameLogic(List<Puzzle> puzzleList) {
        this.puzzleList = puzzleList;
        score = 0;
    }

    public void setNewGameInterface(NewGameInterface newGameInterface) {
        this.newGameInterface = newGameInterface;
    }

    private void startTimer(long time) {
        gameTimer = new GameTimer(time, this);
        gameTimer.start();
    }

    public void newPuzzle() {
        if (MainActivity.PUZZLE_COUNT != 0) end();
        Random random = new Random();
        currentPuzzle = puzzleList.remove(random.nextInt(puzzleList.size()));
        newGameInterface.showPuzzle(currentPuzzle);

        startTimer(SECONDS_FOR_PUZZLE * 1000);
        newGameInterface.setButtonsEnability(true);
    }

    public void addScore(long score) {
        this.score += score;
    }

    public long getScore() {
        return score;
    }

    public void saveHighScore() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.getInstance());
        String player = sharedPreferences.getString("key_name", "Player");
        MainApplication.getInstance().getDataCache().createHighScore(new HighScore(null, player, score));
    }

    @Override
    public void tick(long timeLeft) {
        newGameInterface.showTimer(timeLeft);
        if (timeLeft < 1000) newGameInterface.timeExpired();
    }

    @Override
    public void end() {
        gameTimer.stop();
    }
}
