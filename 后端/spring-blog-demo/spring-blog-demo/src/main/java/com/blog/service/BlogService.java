package com.blog.service;

import com.blog.pojo.dataobject.BlogInfo;
import com.blog.pojo.request.AddBlogRequest;
import com.blog.pojo.request.UpdateBlogRequest;
import com.blog.pojo.response.BlogInfoResponse;
import com.blog.pojo.response.Result;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogDetail(Integer blogId);

    BlogInfo getBlogInfo(Integer blogId);

    Boolean addBlog(AddBlogRequest addBlogRequest);

    Boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    Boolean deleteBlog(@NotNull(message = "blogId不能为null") Integer blogId);
}