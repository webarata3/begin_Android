package com.example.view13;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this, getListData(), R.layout.list,
                new String[] { "no", "name" }, new int[] { R.id.no, R.id.name });
        listView.setAdapter(adapter);
    }

    private List<Map<String, String>> getListData() {
        List<Map<String, String>> listData = new ArrayList<>();

        listData.add(getMapData(new String[][] { { "no", "01" }, { "name", "あいうえお" } }));
        listData.add(getMapData(new String[][] { { "no", "02" }, { "name", "かきくけこ" } }));
        listData.add(getMapData(new String[][] { { "no", "03" }, { "name", "さしすせそ" } }));
        listData.add(getMapData(new String[][] { { "no", "04" }, { "name", "たちつてと" } }));
        listData.add(getMapData(new String[][] { { "no", "05" }, { "name", "なにぬねの" } }));
        listData.add(getMapData(new String[][] { { "no", "06" }, { "name", "はひふへほ" } }));
        listData.add(getMapData(new String[][] { { "no", "07" }, { "name", "まみむめも" } }));
        listData.add(getMapData(new String[][] { { "no", "08" }, { "name", "や　ゆ　よ" } }));
        listData.add(getMapData(new String[][] { { "no", "09" }, { "name", "らりるれろ" } }));
        listData.add(getMapData(new String[][] { { "no", "10" }, { "name", "わをん　　" } }));

        return listData;
    }

    private Map<String, String> getMapData(String[][] values) {
        Map<String, String> map = new HashMap<>();
        for (String[] value : values) {
            map.put(value[0], value[1]);
        }

        return map;
    }
}
