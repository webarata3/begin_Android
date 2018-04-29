package com.example.database05;

import java.util.List;

public interface UiCallback<T> {
    void execute(List<T> list);
}
