package org.example.demo_spring_book.service;

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

//    public List<BookInfo> getList () {
//        List<BookInfo> books = bookDao.mockData(); // 自行生成数据
//        return books;
//    }
    // 根据页数返回图书列表
    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        Integer count = bookInfoMapper.count(); // 获取总记录数
        List<BookInfo> bookInfos = bookInfoMapper.queryBookInfoByPage(pageRequest); // 获取图书列表
        if (count == null || bookInfos == null) {
            return new PageResponse<>(0, null); // 如果查询失败，返回空列表和0总记录数
        }
        // 根据图书记录的status设置statusCN
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else if (bookInfo.getStatus() == 2) {
                bookInfo.setStatusCN("已借出");
            } else if (bookInfo.getStatus() == 0) {
                bookInfo.setStatusCN("已删除");
            }
        }

        return new PageResponse<>(count, bookInfos);
    }
}
