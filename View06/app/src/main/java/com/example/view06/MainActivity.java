package com.example.view06;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            Toast.makeText(MainActivity.this,
                    "checkedId=" + checkedId + " " + group.getCheckedRadioButtonId(),
                    Toast.LENGTH_SHORT).show();
        });
    }
}
