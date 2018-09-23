package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class DataCache {

    private DaoManager daoManager;

    private List<Puzzle> puzzleList;

    public DataCache(DaoManager daoManager) {
        this.daoManager = daoManager;
        puzzleList = daoManager.getAllPuzzles();
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
        for (int i = 0; i < puzzleList.size(); i++) {
            puzzleList.remove(0);
        }
    }


}
