package org.example.demo_spring_book.dao;

import org.example.demo_spring_book.model.BookInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class bookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> books = new ArrayList<>();

        // 生成十五本书及其相关信息
        for (int i = 1; i <= 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("书名" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(500)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i % 5 == 0 ? 2 : 1);
            bookInfo.setStatusCN("%s".formatted((bookInfo.getStatus() == 1) ? "可借阅" : "已借出"));
            books.add(bookInfo);
        }

        return books;
    }
}
