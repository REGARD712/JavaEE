package org.example.demo_spring_book.service;

import org.example.demo_spring_book.dao.bookDao;
import org.example.demo_spring_book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class bookService {
    @Autowired
    bookDao bookDao;
    public List<BookInfo> getList () {
        List<BookInfo> books = bookDao.mockData(); // 自行生成数据
        return books;
    }
}
