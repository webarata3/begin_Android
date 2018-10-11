package com.example.database05;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView allDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allDataTextView = findViewById(R.id.allDataTextView);

        findViewById(R.id.viewButton).setOnClickListener(view -> {
            view();
        });
    }

    private void view() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.executeQuery(db -> {
            BookDao bookDao = new BookDao(db);
            List<Book> bookList = bookDao.selectAll();

            AppExecutors.getInstance().mainThread().execute(() -> {
                String listText = "";
                for (Book book : bookList) {
                    listText = listText + book.getName() + "," + book.getPrice() + "\n";
                }
                allDataTextView.setText(listText);
            });
        });
    }
}
