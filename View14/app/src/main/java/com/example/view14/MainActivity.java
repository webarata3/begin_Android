package com.example.view14;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Sample> sampleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            sampleList.add(new Sample(i, "テスト"));
        }

        SampleAdapter sampleAdapter = new SampleAdapter(this, sampleList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(sampleAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (view.getId()) {
                case R.id.button:
                    Toast.makeText(MainActivity.this, i + "番目のボタンが押されました。",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}
