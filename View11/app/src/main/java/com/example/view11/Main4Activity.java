package com.example.view11;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        findViewById(R.id.button).setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        ListView listView = findViewById(R.id.listView);
        String[] aiueo = getResources().getStringArray(R.array.test_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, aiueo);
        listView.setAdapter(adapter);

        findViewById(R.id.confirmButton).setOnClickListener(view -> {
            String message = "チェックされたインデックス ";
            SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                int key = sparseBooleanArray.keyAt(i);
                message = message + key + ",";
            }
            Toast.makeText(Main4Activity.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
