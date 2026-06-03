package org.example.demo_spring_book.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.model.PageRequest;
import org.example.demo_spring_book.model.PageResponse;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Insert("INSERT INTO book_info (`book_name`, `author`, `count`, `price`, `publish`, `status`) " +
            "VALUES (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("SELECT `book_name`, `author`, `count`, `price`, `publish`, `status` " +
            "FROM book_info WHERE `status` != 0 LIMIT #{offset}, #{pageSize}")
    List<BookInfo> queryBookInfoByPage(PageRequest pageRequest);

    @Select("SELECT count(1) FROM book_info WHERE `status` != 0")
    Integer count();
}
