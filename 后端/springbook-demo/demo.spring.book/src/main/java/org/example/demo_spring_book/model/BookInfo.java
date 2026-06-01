package org.example.demo_spring_book.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price; // 表示金钱一般用decimal或bigdecimal，不要用浮点数
    private String publish;
    private Integer status; // 表示图书的状态：0表示已被删除；1表示可借阅；2表示已借出
    private String statusCN; // 表示图书状态的中文含义，因为中文不能直接存入数据库
    private Date createTime;
    private Date updateTime;
}
