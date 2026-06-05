package org.example.demo_spring_book.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo_spring_book.model.BookInfo;
import org.example.demo_spring_book.model.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Insert("INSERT INTO book_info (`book_name`, `author`, `count`, `price`, `publish`, `status`) " +
            "VALUES (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("SELECT `id`, `book_name`, `author`, `count`, `price`, `publish`, `status` " +
            "FROM book_info WHERE `status` != 0 LIMIT #{offset}, #{pageSize}")
    List<BookInfo> queryBookInfoByPage(PageRequest pageRequest);

    @Select("SELECT count(1) FROM book_info WHERE `status` != 0")
    Integer count();

    @Select("SELECT * FROM book_info WHERE `id` = #{bookId}")
    BookInfo queryBookById(Integer bookId);

    // 采用动态SQL处理，但是注解实现比较麻烦，因此采用XML的方式实现
    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(@RequestParam List<Integer> ids);
}
