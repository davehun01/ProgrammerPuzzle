package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

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


}
