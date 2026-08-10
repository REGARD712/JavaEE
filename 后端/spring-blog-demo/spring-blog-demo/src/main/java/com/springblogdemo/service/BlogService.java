package com.springblogdemo.service;

import com.springblogdemo.pojo.dataobject.BlogInfo;

import java.util.List;

public interface BlogService {
    List<BlogInfo> getList();
}