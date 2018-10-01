package com.example.dave.programmerpuzzle.GameLogic;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.Tools.GameTimer;
import com.example.dave.programmerpuzzle.Tools.GameTimerInterface;

import java.util.List;
import java.util.Random;
import java.util.Timer;

public class GameLogic implements GameTimerInterface {

    private GameLogicInterface gameLogicInterface;

    private List<Puzzle> puzzleList;

    private Puzzle currentPuzzle;

    private long score;

    private GameTimer gameTimer;

    private static final int SECONDS = 20;

    public GameLogic(GameLogicInterface gameLogicInterface, List<Puzzle> puzzleList) {
        this.gameLogicInterface = gameLogicInterface;
        this.puzzleList = puzzleList;
        score = 0;
    }

    private void startTimer(long time) {
        gameTimer = new GameTimer(time, this);
        gameTimer.start();
    }

    public void newPuzzle() {
        Random random = new Random();
        currentPuzzle = puzzleList.remove(random.nextInt(puzzleList.size()));
        System.out.println(puzzleList.size());
        gameLogicInterface.showPuzzle(currentPuzzle);

        startTimer(SECONDS * 1000);
        gameLogicInterface.setButtonsEnability(true);
    }

    public void addScore(long score) {
        this.score += score;
    }

    public long getScore() {
        return score;
    }

    @Override
    public void tick(long timeLeft) {
        gameLogicInterface.showTimer(timeLeft);
        if (timeLeft < 1000) gameLogicInterface.timeExpired();
    }

    @Override
    public void end() {
        gameTimer.stop();
    }
}
