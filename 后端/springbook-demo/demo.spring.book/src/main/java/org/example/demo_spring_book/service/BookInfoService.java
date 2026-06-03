package org.example.demo_spring_book.service;

import org.example.demo_spring_book.enums.BookStatusEnum;
import org.example.demo_spring_book.mapper.BookInfoMapper;
import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.model.PageRequest;
import org.example.demo_spring_book.model.PageResponse;
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

    // 根据页数返回图书列表
    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        Integer count = bookInfoMapper.count(); // 获取总记录数
        List<BookInfo> bookInfos = bookInfoMapper.queryBookInfoByPage(pageRequest); // 获取图书列表
        if (count == null || bookInfos == null) {
            return new PageResponse<>(0, null); // 如果查询失败，返回空列表和0总记录数
        }
        // 将状态码转换为中文描述
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }
        return new PageResponse<>(count, bookInfos);
    }
}
