package com.example.dave.programmerpuzzle.Persistence;

import android.app.Application;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.R;

public class PuzzleInitializer {

    private DataCache dataCache;
    private static boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() {
        if (dataCache.getPuzzleList().size() == 0 || !created) {
            dataCache.deleteAllPuzzles();
            dataCache.createPuzzle(new Puzzle(1L,
                    MainApplication.getInstance().getString(R.string.puzzle_1_description),
                    MainApplication.getInstance().getString(R.string.puzzle_1_code),
                    MainApplication.getInstance().getString(R.string.puzzle_1_language)));
        }
    }

    public void isCreated(boolean created) {
        this.created = created;
    }
}
