package com.example.database01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView allDataTextView;

    private TextView nameTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allDataTextView = findViewById(R.id.allDataTextView);

        nameTextView = findViewById(R.id.nameEditText);
        priceTextView = findViewById(R.id.priceEditText);

        findViewById(R.id.registerButton).setOnClickListener(view -> {
            registerBook();
        });

        readAllData();
    }

    private void readAllData() {
        DatabaseHelper helper = new DatabaseHelper(this);
        String sql = "SELECT * FROM book";
        SQLiteDatabase db = helper.getReadableDatabase();
        try (Cursor cursor = db.rawQuery(sql, null)) {
            String result = "";
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int price = cursor.getInt(cursor.getColumnIndex("price"));
                result = result + name + "," + price + "\n";
            }
            allDataTextView.setText(result);
        }
    }

    private void registerBook() {
        String name = nameTextView.getText().toString();
        nameTextView.setText("");
        int price = Integer.parseInt(priceTextView.getText().toString());
        priceTextView.setText("");

        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "INSERT INTO book(name, price) VALUES(?, ?)";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, name);
        stmt.bindLong(2, price);
        stmt.executeInsert();

        readAllData();
    }
}
