package org.example.demo_spring_book.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.model.PageRequest;
import org.example.demo_spring_book.model.PageResponse;
import org.example.demo_spring_book.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    BookInfoService bookInfoService;

    @PostMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        // 打印日志
        log.info("添加图书, request: {}", bookInfo);
        // 1.逐一校验数据
        if (!StringUtils.hasLength(bookInfo.getBookName())) {
            log.error("图书名称不合法, request: {}", bookInfo);
            return "图书名称不合法";
        }
        if (!StringUtils.hasLength(bookInfo.getAuthor())) {
            log.error("作者名称不合法, request: {}", bookInfo);
            return "作者名称不合法";
        }
        if (bookInfo.getCount() == null) {
            log.error("图书数目不合法, request: {}", bookInfo);
            return "图书数目不合法";
        }
        if (bookInfo.getPrice() == null) {
            log.error("图书价格不合法, request: {}", bookInfo);
            return "图书价格不合法";
        }
        if (!StringUtils.hasLength(bookInfo.getPublish())) {
            log.error("出版商名称不合法, request: {}", bookInfo);
            return "出版商名称不合法";
        }
        if (bookInfo.getStatus() == null) {
            log.error("图书状态不合法, request: {}", bookInfo);
            return "图书状态不合法";
        }

        // 2.调用service层
        try {
            // 添加成功返回空字符串
            bookInfoService.addBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("添加图书异常, e: ", e);
            return "添加图书异常";
        }
    }

//    @RequestMapping("/getList")
//    public List<BookInfo> getList () {
//        return bookInfoService.getList();
//    }
    @GetMapping("/getListByPage")
    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        return bookInfoService.getListByPage(pageRequest);
    }
}
