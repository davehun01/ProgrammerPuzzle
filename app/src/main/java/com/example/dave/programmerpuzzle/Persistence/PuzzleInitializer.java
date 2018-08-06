package com.example.dave.programmerpuzzle.Persistence;

import android.provider.ContactsContract;

import com.example.dave.programmerpuzzle.DaoSession;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

public class PuzzleInitializer {

    private DataCache dataCache;
    private boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() {
        if (dataCache.getPuzzleList().size() == 0 || !created) {
            //dataCache.createPuzzle(...);
        }
    }
}
