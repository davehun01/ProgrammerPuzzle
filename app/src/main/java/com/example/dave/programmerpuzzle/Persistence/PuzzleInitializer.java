package com.example.dave.programmerpuzzle.Persistence;

public class PuzzleInitializer {

    private DataCache dataCache;
    private static boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() {
        if (dataCache.getPuzzleList().size() == 0 || !created) {
            dataCache.deleteAllPuzzles();
            //dataCache.createPuzzle(...);
        }
    }

    public void isCreated(boolean created) {
        this.created = created;
    }
}
