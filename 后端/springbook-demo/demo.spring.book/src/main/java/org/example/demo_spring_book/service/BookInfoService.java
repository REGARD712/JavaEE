package org.example.demo_spring_book.service;

import org.example.demo_spring_book.dao.bookDao;
import org.example.demo_spring_book.mapper.BookInfoMapper;
import org.example.demo_spring_book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookInfoService {
//    @Autowired
//    bookDao bookDao;
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public void addBook(BookInfo bookInfo) {
        bookInfoMapper.addBook(bookInfo);
    }

//    public List<BookInfo> getList () {
//        List<BookInfo> books = bookDao.mockData(); // 自行生成数据
//        return books;
//    }
}
