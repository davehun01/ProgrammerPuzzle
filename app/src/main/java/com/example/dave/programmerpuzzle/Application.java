package com.example.dave.programmerpuzzle;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.*;

public class Application extends android.app.Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "ProgrammerPuzzle.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getPuzzleDao().loadAll().size() == 0){
            mDaoSession.getPuzzleDao().insert(new Puzzle(1L,"test description", "test code"));
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
