package org.example.demo_spring_book.controller;

import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    bookService bookService;
    @RequestMapping("/getList")
    public List<BookInfo> getList () {
        return bookService.getList();
    }
}
