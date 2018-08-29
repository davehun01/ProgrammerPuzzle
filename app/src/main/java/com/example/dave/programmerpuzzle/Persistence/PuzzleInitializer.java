package com.example.dave.programmerpuzzle.Persistence;

import android.app.Application;
import android.content.res.AssetManager;

import com.example.dave.programmerpuzzle.Application.MainApplication;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;
import com.example.dave.programmerpuzzle.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PuzzleInitializer {

    private DataCache dataCache;
    private static boolean created = false;

    public PuzzleInitializer(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void initPuzzles() throws IOException {
        if (dataCache.getPuzzleList().size() == 0 || !created) {
            dataCache.deleteAllPuzzles();
            createPuzzles();
        }
    }

    private void createPuzzles() throws IOException {
        AssetManager assetManager = MainApplication.getInstance().getAssets();
        String[] files = assetManager.list("");
        BufferedReader reader = null;
        StringBuilder code = new StringBuilder();
        StringBuilder description = new StringBuilder();
        String language = "";
        for (String currentFile : files) {
            String[] split = currentFile.split(".");
            if (split[1].equals("cpp")) language = "C++";
            if (split[1].equals("java")) language = "Java";
            if (split[1].equals("py")) language = "Python";
            reader = new BufferedReader(new InputStreamReader(assetManager.open(currentFile)));
            String line;

            while (!(line = reader.readLine()).equals("//DESCRIPTION:")) {
                code.append(line);
                code.append('\n');
            }
            reader.readLine();
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
