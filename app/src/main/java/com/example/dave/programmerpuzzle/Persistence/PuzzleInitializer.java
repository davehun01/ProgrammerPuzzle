package com.example.dave.programmerpuzzle.Persistence;

import android.content.res.AssetManager;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuzzleInitializer {

    private DataCache dataCache;
    private static boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() {
        try {
            if (dataCache.getPuzzleList().size() == 0 || !created) {
                dataCache.deleteAllPuzzles();
                createPuzzles();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createPuzzles() throws IOException {
        AssetManager assetManager = MainApplication.getInstance().getAssets();
        String[] files = assetManager.list("");
        BufferedReader reader = null;
        StringBuilder code;
        StringBuilder description;
        String language = "";
        for (String currentFile : files) {
            String[] split = currentFile.split("\\.");
            if (split.length < 2) continue;
            if (split[1].equals("cpp")) {
                language = "C++";
            } else if (split[1].equals("java")) {
                language = "Java";
            } else if (split[1].equals("py")) {
                language = "Python";
            } else {
                continue;
            }

            reader = new BufferedReader(new InputStreamReader(assetManager.open(currentFile)));
            code = new StringBuilder();
            description = new StringBuilder();
            String line;

            while (!(line = reader.readLine()).equals("//DESCRIPTION:")) {
                code.append(line);
                code.append('\n');
            }

            while ((line = reader.readLine()) != null) {
                description.append(line);
                description.append('\n');
            }

            reader.close();
            dataCache.createPuzzle(new Puzzle((Long) null, description.toString(), code.toString(), language));
        }

    }


    public void isCreated(boolean created) {
        this.created = created;
    }
}
