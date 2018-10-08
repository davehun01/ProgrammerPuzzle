package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class DataCache {

    private DaoManager daoManager;

    private List<Puzzle> puzzleList;

    private List<HighScore> highScoreList;

    public DataCache(DaoManager daoManager) {
        this.daoManager = daoManager;
        puzzleList = daoManager.getAllPuzzles();
        highScoreList = daoManager.getAllHighScores();
    }

    public List<Puzzle> getPuzzleList() {
        return puzzleList;
    }

    public List<Puzzle> getPuzzleList(String language) {
        List<Puzzle> puzzles = new ArrayList<>();
        for (Puzzle puzzle : puzzleList) {
            if (puzzle.getLanguage().equals(language)) {
                puzzles.add(puzzle);
            }
        }
        return puzzles;
    }

    public void createPuzzle(Puzzle puzzle) {
        Long id = daoManager.insertPuzzle(puzzle);
        puzzle.setId(id);
        puzzleList.add(puzzle);
    }

    public void deletePuzzle(Puzzle puzzle) {
        daoManager.deletePuzzle(puzzle);
        puzzleList.remove(puzzle);
    }

    public void updatePuzzle(Puzzle puzzle) {
        daoManager.updatePuzzle(puzzle);
        for (int i = 0; i < puzzleList.size(); i++) {
            if (puzzleList.get(i).getId().equals(puzzle.getId())) {
                puzzleList.set(i, puzzle);
                break;
            }
        }
    }

    public void deleteAllPuzzles() {
        daoManager.deleteAllPuzzles();
        puzzleList = new ArrayList<>();
    }

    public List<HighScore> getHighScoreList() {
        return highScoreList;
    }

    public void createHighScore(HighScore highScore) {
        Long id = daoManager.insertHighScore(highScore);
        highScore.setId(id);
        highScoreList.add(highScore);
    }

    public void deleteAllHighScores() {
        daoManager.deleteAllHighScores();
        highScoreList = new ArrayList<>();
    }
}
