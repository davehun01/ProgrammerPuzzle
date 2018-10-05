package com.example.dave.programmerpuzzle.GameLogic;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

public interface NewGameInterface {
    void showPuzzle(Puzzle puzzle);
    void timeExpired();
    void gameEnd();
    void showTimer(long timeLeft);
    void setButtonsEnability(boolean enabled);
}
