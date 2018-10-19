package com.example.view15;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Sample> sampleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            sampleList.add(new Sample(i, "テスト"));
        }

        RecyclerView recycleView = findViewById(R.id.recyclerView);
        SampleAdapter adapter = new SampleAdapter(this, sampleList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(adapter);
    }
}
