package com.example.database05;

import android.content.Context;

import java.util.concurrent.Executor;

public abstract class BaseDatabase {
    private DatabaseHelper databaseHelper;

    public BaseDatabase(Context context, Executor diskIoExecutor) {

    }
}
