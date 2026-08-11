package com.springblogdemo.service;

import com.springblogdemo.pojo.dataobject.BlogInfo;
import com.springblogdemo.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getList();
}