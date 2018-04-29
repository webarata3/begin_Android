package com.example.database01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView allDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allDataTextView = findViewById(R.id.allDataTextView);

        findViewById(R.id.viewButton).setOnClickListener(view-> {
            viewData();
        });
    }

    private void viewData() {
        DatabaseHelper helper = new DatabaseHelper(this);
        try (SQLiteDatabase db = helper.getWritableDatabase()) {
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
    }
}
