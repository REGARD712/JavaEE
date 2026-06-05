package org.example.demo_spring_book.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class CheckIllegal {
    public static String checkBookInfo(BookInfo bookInfo) {
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
        return "";
    }
}
