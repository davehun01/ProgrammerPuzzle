package com.example.dave.programmerpuzzle.Persistence.Entities;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.dave.programmerpuzzle.Persistence.Entities.HighScore;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

import com.example.dave.programmerpuzzle.Persistence.Entities.HighScoreDao;
import com.example.dave.programmerpuzzle.Persistence.Entities.PuzzleDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig highScoreDaoConfig;
    private final DaoConfig puzzleDaoConfig;

    private final HighScoreDao highScoreDao;
    private final PuzzleDao puzzleDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        highScoreDaoConfig = daoConfigMap.get(HighScoreDao.class).clone();
        highScoreDaoConfig.initIdentityScope(type);

        puzzleDaoConfig = daoConfigMap.get(PuzzleDao.class).clone();
        puzzleDaoConfig.initIdentityScope(type);

        highScoreDao = new HighScoreDao(highScoreDaoConfig, this);
        puzzleDao = new PuzzleDao(puzzleDaoConfig, this);

        registerDao(HighScore.class, highScoreDao);
        registerDao(Puzzle.class, puzzleDao);
    }
    
    public void clear() {
        highScoreDaoConfig.clearIdentityScope();
        puzzleDaoConfig.clearIdentityScope();
    }

    public HighScoreDao getHighScoreDao() {
        return highScoreDao;
    }

    public PuzzleDao getPuzzleDao() {
        return puzzleDao;
    }

}
