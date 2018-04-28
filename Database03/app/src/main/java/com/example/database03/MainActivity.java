package com.example.database03;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView allDataTextView;

    private EditText nameEditText;
    private EditText priceEditText;

    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allDataTextView = findViewById(R.id.allDataTextView);
        nameEditText = findViewById(R.id.nameEditText);
        priceEditText = findViewById(R.id.priceEditText);

        findViewById(R.id.viewButton).setOnClickListener(view-> {
            viewData();
        });

        findViewById(R.id.insertButton).setOnClickListener(view -> {
            insert();
        });

        helper = new DatabaseHelper(this);
    }

    private void viewData() {
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "SELECT * FROM book";
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

    private void insert() {
        String sql = "INSERT INTO book(name, price) VALUES(?, ?)";
        String name = nameEditText.getText().toString();
        int price = Integer.parseInt(priceEditText.getText().toString());

        SQLiteDatabase db = helper.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, name);
        stmt.bindLong(2, price);
        long id = stmt.executeInsert();

        Toast.makeText(this, "id=" + id, Toast.LENGTH_SHORT).show();

        nameEditText.setText("");
        priceEditText.setText("");
    }
}
