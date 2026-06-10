package org.example.demo_spring_book.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.demo_spring_book.constants.Constant;
import org.example.demo_spring_book.enums.BookStatusEnum;
import org.example.demo_spring_book.model.*;
import org.example.demo_spring_book.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.demo_spring_book.model.CheckIllegal.checkBookInfo;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    BookInfoService bookInfoService;

    @RequestMapping("/addBook")
    public Result addBook(BookInfo bookInfo) {
        // 打印日志
        log.info("添加图书, request: {}", bookInfo);
        // 1.逐一校验数据
        if (!checkBookInfo(bookInfo).isEmpty()) {
            String errMsg = checkBookInfo(bookInfo);
            return Result.fail(errMsg, bookInfo);
        }

        // 2.调用service层
        try {
            // 添加成功返回空字符串
            bookInfoService.addBook(bookInfo);
            return Result.success(bookInfo);
        } catch (Exception e) {
            log.error("添加图书异常, e: ", e);
            return Result.fail("添加图书异常", bookInfo);
        }
    }

    @RequestMapping("/getListByPage")
    public Result<PageResponse<BookInfo>> getListByPage(PageRequest pageRequest, HttpSession session) {
        // 打印日志
        log.info("获取图书列表，pageRequest: {}", pageRequest);
        // 调用service层处理
        PageResponse<BookInfo> pageResponse = bookInfoService.getListByPage(pageRequest);
        return Result.success(pageResponse);
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书信息，bookId: {}", bookId);
        return bookInfoService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        // 打印日志
        log.info("更新图书信息，bookInfo: {}", bookInfo);
        // 调用service层处理
        try {
            // 成功更新
            bookInfoService.updateBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("更新图书信息异常，e: ", e);
            return "更新图书信息异常";
        }
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        log.info("删除图书，bookId: {}", bookId);
        try {
            // 逻辑删除：利用update接口更新图书的status为0即可
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookStatusEnum.DELETED.getCode());
            bookInfoService.updateBook(bookInfo);
            // 删除成功
            return "";
        } catch (Exception e) {
            log.error("删除图书异常，e: ", e);
            return "删除图书异常";
        }
    }

    @RequestMapping("/batchDelete")
    public String batchDelete(@RequestParam List<Integer> ids) {
        log.info("批量删除图书，ids: {}", ids);
        try {
            bookInfoService.batchDelete(ids);
            // 成功
            return "";
        } catch (Exception e) {
            log.error("批量删除图书异常，e: ", e);
            return "批量删除图书异常";
        }
    }
}
