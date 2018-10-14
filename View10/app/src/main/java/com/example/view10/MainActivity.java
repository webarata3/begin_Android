package com.example.view10;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch testSwitch = findViewById(R.id.testSwitch);
        testSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            Toast.makeText(MainActivity.this, "チェック？ " + b, Toast.LENGTH_SHORT).show();
        });
    }
}
