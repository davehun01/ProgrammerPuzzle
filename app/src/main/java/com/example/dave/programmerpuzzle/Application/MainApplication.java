package com.example.dave.programmerpuzzle.Application;

import com.example.dave.programmerpuzzle.Persistence.DaoManager;
import com.example.dave.programmerpuzzle.Persistence.DataCache;
import com.example.dave.programmerpuzzle.Persistence.Entities.DaoMaster;
import com.example.dave.programmerpuzzle.Persistence.Entities.DaoSession;
import com.example.dave.programmerpuzzle.Persistence.PuzzleInitializer;

public class MainApplication extends android.app.Application {

    private static MainApplication mainApplication;

    private DaoSession daoSession;
    private DaoManager daoManager;
    private DataCache dataCache;

    public static MainApplication getInstance() {
        return mainApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        daoSession = new DaoMaster(new DaoMaster
                    .DevOpenHelper(this, "ProgrammerPuzzle.db")
                    .getWritableDb())
                    .newSession();

        daoManager = new DaoManager(daoSession);
        dataCache = new DataCache(daoManager);

        new PuzzleInitializer(dataCache).initPuzzles();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoManager getDaoManager() {
        return daoManager;
    }

    public DataCache getDataCache() {
        return dataCache;
    }
}
