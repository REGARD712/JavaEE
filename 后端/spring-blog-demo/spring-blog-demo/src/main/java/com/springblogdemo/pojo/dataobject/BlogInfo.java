package com.springblogdemo.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.springblogdemo.common.util.DateUtils;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BlogInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer user_id;
    private Integer deleteFlag;
    private Date createTime;
    private LocalDate updateTime;
}
