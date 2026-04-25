package org.example.demo_spring_book.controller;

import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.service.bookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList () {
        bookService bookService = new bookService();
        return bookService.getList();
    }
}
