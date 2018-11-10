package com.example.dave.programmerpuzzle.Persistence;

import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataCacheTest {

    private DaoManager daoManager;

    private DataCache dataCache;

    @Test
    public void testGetPuzzleList() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "c");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList().size() == 1);
        assertEquals(true, dataCache.getPuzzleList().get(0).getDescription().equals("a"));
        assertEquals(true, dataCache.getPuzzleList().get(0).getCode().equals("b"));
        assertEquals(true, dataCache.getPuzzleList().get(0).getLanguage().equals("c"));
    }

    @Test
    public void testGetPuzzleListLang() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "Java");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList("Java").size() == 1);
        assertEquals(true, dataCache.getPuzzleList().get(0).getLanguage().equals("Java"));
        assertEquals(true, dataCache.getPuzzleList("C++").isEmpty());
        assertEquals(true, dataCache.getPuzzleList("Python").isEmpty());
    }

    @Test
    public void testCreatePuzzle() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "Java");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList().size() == 1);
        assertEquals(true, dataCache.getPuzzleList().get(0).getDescription().equals("a"));
        assertEquals(true, dataCache.getPuzzleList().get(0).getCode().equals("b"));
        assertEquals(true, dataCache.getPuzzleList().get(0).getLanguage().equals("Java"));
    }

    @Test
    public void testDeletePuzzle() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "Java");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList().size() == 1);

        dataCache.deletePuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());
    }

    @Test
    public void testUpdatePuzzle() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "Java");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);

        assertEquals(true, dataCache.getPuzzleList().size() == 1);
        assertEquals(true, dataCache.getPuzzleList().get(0).getLanguage().equals("Java"));

        Puzzle newPuzzle = new Puzzle(1L, "a", "b", "C++");
        dataCache.updatePuzzle(newPuzzle);

        assertEquals(true, dataCache.getPuzzleList().get(0).getLanguage().equals("C++"));
    }

    @Test
    public void testDeleteAllPuzzles() {
        daoManager = mock(DaoManager.class);
        Puzzle puzzle = new Puzzle(null, "a", "b", "Java");
        Puzzle anotherPuzzle = new Puzzle(null, "a", "b", "C++");
        when(daoManager.insertPuzzle(puzzle)).thenReturn(1L);
        when(daoManager.insertPuzzle(anotherPuzzle)).thenReturn(2L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getPuzzleList().isEmpty());

        dataCache.createPuzzle(puzzle);
        dataCache.createPuzzle(anotherPuzzle);

        assertEquals(true, dataCache.getPuzzleList().size() == 2);

        dataCache.deleteAllPuzzles();

        assertEquals(true, dataCache.getPuzzleList().isEmpty());
    }

    @Test
    public void testGetHighScoreList() {
        daoManager = mock(DaoManager.class);
        HighScore highScore = new HighScore(null, "Player", 1000);
        when(daoManager.insertHighScore(highScore)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getHighScoreList().isEmpty());

        dataCache.createHighScore(highScore);

        assertEquals(true, dataCache.getHighScoreList().size() == 1);
        assertEquals(true, dataCache.getHighScoreList().get(0).getPlayer().equals("Player"));
        assertEquals(true, dataCache.getHighScoreList().get(0).getPoints() == 1000);
    }

    @Test
    public void testCreateHighScore() {
        daoManager = mock(DaoManager.class);
        HighScore highScore = new HighScore(null, "Player", 1000);
        when(daoManager.insertHighScore(highScore)).thenReturn(1L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getHighScoreList().isEmpty());

        dataCache.createHighScore(highScore);

        assertEquals(true, dataCache.getHighScoreList().size() == 1);
        assertEquals(true, dataCache.getHighScoreList().get(0).getPlayer().equals("Player"));
        assertEquals(true, dataCache.getHighScoreList().get(0).getPoints() == 1000);
    }

    @Test
    public void testDeleteAllHighScores() {
        daoManager = mock(DaoManager.class);
        HighScore highScore = new HighScore(null, "Player", 1000);
        HighScore anotherHighScore = new HighScore(null, "Player2", 2000);

        when(daoManager.insertHighScore(highScore)).thenReturn(1L);
        when(daoManager.insertHighScore(anotherHighScore)).thenReturn(2L);
        dataCache = new DataCache(daoManager);

        assertEquals(true, dataCache.getHighScoreList().isEmpty());

        dataCache.createHighScore(highScore);
        dataCache.createHighScore(anotherHighScore);

        assertEquals(true, dataCache.getHighScoreList().size() == 2);

        dataCache.deleteAllHighScores();

        assertEquals(true, dataCache.getHighScoreList().isEmpty());
    }
}