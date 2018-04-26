package com.example.database02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "book.db";

    private static final int DATABASE_VERSION = 1;

    private static final String[] INIT_DATA = {
            "INSERT INTO book(name, price) VALUES('Android入門', 2980)",
            "INSERT INTO book(name, price) VALUES('Java入門', 1980)"};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE book(";
        ddl += "id INTEGER PRIMARY KEY AUTOINCREMENT,";
        ddl += "name TEXT,";
        ddl += "price INTEGER";
        ddl += ")";

        db.execSQL(ddl);

        try {
            db.beginTransaction();

            for (String initData : INIT_DATA) {
                db.execSQL(initData);
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
