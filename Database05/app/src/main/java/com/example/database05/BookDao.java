package com.example.database05;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final String INSERT_SQL = "INSERT INTO book(name, price) VALUES(?, ?)";

    private SQLiteDatabase db;

    public BookDao(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(Book book) {
        SQLiteStatement stmt = db.compileStatement(INSERT_SQL);
        stmt.bindString(1, book.getName());
        stmt.bindLong(2, book.getPrice());
        stmt.executeInsert();
    }

    private Book selectOne(Cursor cursor) {
        Book resultBook = new Book();
        resultBook.setName(cursor.getString(cursor.getColumnIndex("name")));
        resultBook.setPrice(cursor.getInt(cursor.getColumnIndex("price")));

        return resultBook;
    }

    public List<Book> selectAll() {
        List<Book> bookList = new ArrayList<>();
        try (Cursor cursor = db.rawQuery("SELECT * FROM book", null)) {
            while (cursor.moveToNext()) {
                Book book = selectOne(cursor);
                bookList.add(book);
            }
        }
        return bookList;
    }
}
