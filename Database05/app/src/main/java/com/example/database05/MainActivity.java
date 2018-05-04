package com.example.database05;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppExecutors appExecutors;
    private AppDatabase appDatabase;

    private TextView allDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appExecutors = new AppExecutors();

        appDatabase = AppDatabase.getInstance(DatabaseHelper.getInstance(this, appExecutors));

        allDataTextView = findViewById(R.id.allDataTextView);

        findViewById(R.id.viewButton).setOnClickListener(view -> {
            view();
        });
    }

    private void view() {
        appDatabase.executeQuery(db -> {
            BookDao bookDao = new BookDao(db);
            List<Book> bookList = bookDao.selectAll();

            appExecutors.mainThread().execute(() -> {
                String listText = "";
                for (Book book : bookList) {
                    listText = listText + book.getName() + "," + book.getPrice() + "\n";
                }
                allDataTextView.setText(listText);
            });
        });
    }
}
