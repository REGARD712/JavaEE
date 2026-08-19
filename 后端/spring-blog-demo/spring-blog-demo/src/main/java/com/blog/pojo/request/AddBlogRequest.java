package com.blog.pojo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddBlogRequest {
    @NotNull(message = "作者id不能为null")
    private Integer userId;

    @NotBlank(message = "标题不能为空")
    @Length(max = 20, message = "标题长度必须在1-20个字符之间")
    private String title;

    @NotBlank(message = "内容不能为空")
    @Length(max = 1000, message = "内容长度必须在1-1000个字符之间")
    private String content;
}
