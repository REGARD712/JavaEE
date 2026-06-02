package org.example.demo_spring_book.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.demo_spring_book.model.BookInfo;

@Mapper
public interface BookInfoMapper {
    @Insert("INSERT INTO book_info (`book_name`, `author`, `count`, `price`, `publish`, `status`) " +
            "VALUES (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer addBook(BookInfo bookInfo);
}
