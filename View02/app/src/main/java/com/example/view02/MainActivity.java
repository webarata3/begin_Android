package com.example.view02;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.errorButton).setOnClickListener(view -> {
            TextInputEditText textInputEditText = MainActivity.this.findViewById(R.id.textInputEditText);
            textInputEditText.setError("エラーメッセージ");
        });

        TextView textView = findViewById(R.id.textView);
        ((TextInputEditText) findViewById(R.id.textInputEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
