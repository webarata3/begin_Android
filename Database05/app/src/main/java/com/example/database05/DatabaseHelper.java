package com.example.database05;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "book.db";

    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        AppExecutors.getInstance().diskIo().execute(() -> {
            String ddl = "CREATE TABLE book(";
            ddl += "id INTEGER PRIMARY KEY AUTOINCREMENT,";
            ddl += "name TEXT,";
            ddl += "price INTEGER";
            ddl += ")";
            db.execSQL(ddl);

            BookDao bookDao = new BookDao(db);
            bookDao.insert(new Book("Android入門", 2980));
            bookDao.insert(new Book("Java入門", 1980));
        });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void executeInTransaction(CallbackSql callbackSql) {
        SQLiteDatabase db = getWritableDatabase();

        AppExecutors.getInstance().diskIo().execute(() -> {
            db.beginTransaction();
            try {
                callbackSql.execute(db);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        });
    }

    public void executeQuery(CallbackSql callbackSql) {
        SQLiteDatabase db = getReadableDatabase();

        AppExecutors.getInstance().diskIo().execute(() -> {
            callbackSql.execute(db);
        });
    }
}
