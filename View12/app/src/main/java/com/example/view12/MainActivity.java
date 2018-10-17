package com.example.view12;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String[] LIST_DATA = {"あいうえお", "かきくけこ", "さしすせそ",
            "たちつてと", "なにぬねの", "はひふへほ", "まみむめも", "や　ゆ　よ",
            "らりるれろ", "わをん"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.list, LIST_DATA);
        listView.setAdapter(arrayAdapter);
    }
}
