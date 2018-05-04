package com.example.database05;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "book.db";

    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;
    private final AppExecutors appExecutors;

    private DatabaseHelper(Context context, AppExecutors appExecutors) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.appExecutors = appExecutors;
    }

    public static synchronized DatabaseHelper getInstance(Context context, AppExecutors appExecutors) {
        if (instance == null) {
            instance = new DatabaseHelper(context, appExecutors);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE book(";
        ddl += "id INTEGER PRIMARY KEY AUTOINCREMENT,";
        ddl += "name TEXT,";
        ddl += "price INTEGER";
        ddl += ")";

        db.execSQL(ddl);

        appExecutors.diskIo().execute(() -> {
            db.beginTransaction();
            try {
                BookDao bookDao = new BookDao(db);
                bookDao.insert(new Book("Android入門", 2980));
                bookDao.insert(new Book("Java入門", 1980));
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void executeInTransaction(SQLiteDatabase db, CallbackSql callbackSql) {
        appExecutors.diskIo().execute(() -> {
            db.beginTransaction();
            try {
                callbackSql.execute(db);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        });
    }

    public void executeQuery(SQLiteDatabase db, CallbackSql callbackSql) {
        appExecutors.diskIo().execute(() -> {
            callbackSql.execute(db);
        });
    }
}
