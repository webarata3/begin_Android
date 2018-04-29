package com.example.database05;

import android.app.Application;

public class BasicApp extends Application {
    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        appExecutors = new AppExecutors();
    }

    public DatabaseHelper getDatabaseHelper() {
        return DatabaseHelper.getInstance (this, appExecutors);
    }

    public AppDatabase getAppDatabase() {
        return AppDatabase.getInstance(getDatabaseHelper());
    }
}
