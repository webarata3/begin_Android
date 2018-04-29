package com.example.database05;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private final Executor diskIo;

    private AppExecutors(Executor diskIo) {
        this.diskIo = diskIo;
    }

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor());
    }

    public Executor diskIo() {
        return diskIo;
    }
}
