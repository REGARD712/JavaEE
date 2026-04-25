package org.example.demo_spring_book.service;

import org.example.demo_spring_book.dao.bookDao;
import org.example.demo_spring_book.model.BookInfo;

import java.util.List;

public class bookService {
    public List<BookInfo> getList () {
        bookDao bookDao = new bookDao();
        List<BookInfo> books = bookDao.mockData(); // 自行生成数据
        return books;
    }
}
