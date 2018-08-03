package com.example.dave.programmerpuzzle.Application;

import com.example.dave.programmerpuzzle.DaoMaster;
import com.example.dave.programmerpuzzle.DaoSession;
import com.example.dave.programmerpuzzle.Persistence.DataCache;
import com.example.dave.programmerpuzzle.Persistence.DaoManager;
import com.example.dave.programmerpuzzle.Persistence.Entities.Puzzle;

public class Application extends android.app.Application {
    private DaoSession mDaoSession;
    private DaoManager mDaoManager;
    private DataCache mDataCache;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "ProgrammerPuzzle.db").getWritableDb()).newSession();

        mDaoManager = new DaoManager(mDaoSession);
        mDataCache = new DataCache(mDaoManager);

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getPuzzleDao().loadAll().size() == 0){
            mDaoSession.getPuzzleDao().insert(new Puzzle(1L,"test description", "test code"));
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public DaoManager getDaoManager() {
        return mDaoManager;
    }

    public DataCache getDataCache() {
        return mDataCache;
    }
}
