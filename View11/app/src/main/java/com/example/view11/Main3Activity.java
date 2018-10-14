package com.example.view11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        findViewById(R.id.button).setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), Main4Activity.class);
            startActivity(intent);
        });

        ListView listView = findViewById(R.id.listView);
        String[] aiueo = getResources().getStringArray(R.array.test_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, aiueo);
        listView.setAdapter(adapter);

        findViewById(R.id.confirmButton).setOnClickListener(view -> {
            int position = listView.getCheckedItemPosition();
            Toast.makeText(Main3Activity.this,
                    "選択値は= " + listView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });
    }
}
