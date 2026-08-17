package com.blog.service;

import com.blog.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogDetail(Integer blogId);
}