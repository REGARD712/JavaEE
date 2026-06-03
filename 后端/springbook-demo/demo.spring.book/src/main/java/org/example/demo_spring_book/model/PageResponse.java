package org.example.demo_spring_book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponse<T> { // 用泛型表示分页响应中的记录类型
    private Integer total;
    private List<T> records;
}
