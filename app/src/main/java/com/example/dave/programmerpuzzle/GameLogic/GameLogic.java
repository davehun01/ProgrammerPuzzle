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

    private int score;

    private GameTimer gameTimer;

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
        gameLogicInterface.showPuzzle(currentPuzzle);

        startTimer(300 * 1000);
        gameLogicInterface.setButtonsEnability(true);
    }

    @Override
    public void tick(long timeLeft) {
        gameLogicInterface.showTimer(timeLeft);
    }

    @Override
    public void end() {

    }
}
