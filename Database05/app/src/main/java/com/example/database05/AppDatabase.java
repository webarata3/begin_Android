package com.example.database05;

import android.database.sqlite.SQLiteDatabase;

public class AppDatabase {
    private static AppDatabase instance;
    private final DatabaseHelper databaseHelper;
    private final SQLiteDatabase db;

    private AppDatabase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
        db = databaseHelper.getWritableDatabase();
    }

    public static synchronized AppDatabase getInstance(DatabaseHelper databaseHelper) {
        if (instance == null) {
            instance = new AppDatabase(databaseHelper);
        }
        return instance;
    }

    public void executeInTransaction(ExecuteSql executeSql) {
        databaseHelper.executeInTransaction(db, executeSql);
    }

    public void executeQuery(FetchDb fetchDb) {
        databaseHelper.executeQuery(db, fetchDb);
    }
}
