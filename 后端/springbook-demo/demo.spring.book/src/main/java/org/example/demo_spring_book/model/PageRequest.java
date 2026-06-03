package org.example.demo_spring_book.model;

import lombok.Data;

@Data
public class PageRequest {
    private Integer currentPage = 1; // 当前页面，默认为第一页
    private Integer pageSize = 10; // 页面的大小，默认十页

    public Integer getOffset() {
        return (currentPage - 1) * pageSize;
    }
}
