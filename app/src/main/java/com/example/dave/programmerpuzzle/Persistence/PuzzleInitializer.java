package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

public class PuzzleInitializer {

    private DataCache dataCache;
    private static boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() {
        if (dataCache.getPuzzleList().size() == 0 || !created) {
            dataCache.deleteAllPuzzles();
            dataCache.createPuzzle(new Puzzle(1L, "test description", "test code", "C++"));
        }
    }

    public void isCreated(boolean created) {
        this.created = created;
    }
}
