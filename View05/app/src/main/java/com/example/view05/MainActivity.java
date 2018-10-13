package com.example.view05;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this,
                    "checkは" + checkBox.isChecked(), Toast.LENGTH_SHORT).show();
        });
    }
}
