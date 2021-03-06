package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.DaoSession;
import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.Persistence.Entities.HighScoreDao;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.Persistence.Entities.PuzzleDao;

import java.util.List;

public class DaoManager {

    private PuzzleDao puzzleDao;

    private HighScoreDao highScoreDao;

    public DaoManager(DaoSession daoSession) {
        puzzleDao = daoSession.getPuzzleDao();
        highScoreDao = daoSession.getHighScoreDao();
    }

    public List<Puzzle> getAllPuzzles() {
        return puzzleDao.loadAll();
    }

    public Long insertPuzzle(Puzzle puzzle) {
        return puzzleDao.insert(puzzle);
    }

    public void updatePuzzle(Puzzle puzzle) {
        puzzleDao.update(puzzle);
    }

    public void deletePuzzle(Puzzle puzzle) {
        puzzleDao.delete(puzzle);
    }

    public void deleteAllPuzzles() { puzzleDao.deleteAll(); }

    public List<HighScore> getAllHighScores() { return highScoreDao.loadAll(); }

    public Long insertHighScore(HighScore highScore) { return highScoreDao.insert(highScore); }

    public void deleteAllHighScores() { highScoreDao.deleteAll(); }
}
