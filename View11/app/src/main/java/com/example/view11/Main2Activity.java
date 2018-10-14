package com.example.view11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.button).setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), Main3Activity.class);
            startActivity(intent);
        });

        ListView listView = findViewById(R.id.listView);
        String[] aiueo = getResources().getStringArray(R.array.test_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, aiueo);
        listView.setAdapter(adapter);
    }
}
