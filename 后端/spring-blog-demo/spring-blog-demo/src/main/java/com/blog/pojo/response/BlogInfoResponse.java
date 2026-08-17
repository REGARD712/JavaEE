package com.blog.pojo.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfoResponse {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer user_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

//    public String getCreateTime() {
//        return DateUtils.dateFormat(createTime);
//    }
}