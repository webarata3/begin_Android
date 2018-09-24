package com.example.database05;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AppDatabase {
    private static AppDatabase instance;
    private final DatabaseHelper databaseHelper;
    private final SQLiteDatabase db;

    private AppDatabase(Context context, AppExecutors appExecutorsr) {
        this.databaseHelper = DatabaseHelper.getInstance(context, appExecutorsr);
        db = databaseHelper.getWritableDatabase();
    }

    public static synchronized AppDatabase getInstance(Context context, AppExecutors appExecutors) {
        if (instance == null) {
            instance = new AppDatabase(context, appExecutors);
        }
        return instance;
    }

    public void executeInTransaction(CallbackSql callbackSql) {
        databaseHelper.executeInTransaction(db, callbackSql);
    }

    public void executeQuery(CallbackSql callbackSql) {
        databaseHelper.executeQuery(db, callbackSql);
    }
}
