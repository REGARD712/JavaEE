package com.springblogdemo.controller;

import com.springblogdemo.pojo.dataobject.BlogInfo;
import com.springblogdemo.service.BlogInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogInfoController {
    @Resource(name = "blogInfoServiceImpl")
    private BlogInfoService blogInfoService;

    @RequestMapping("/getList")
    public List<BlogInfo> getList() {
        log.info("获取博客列表");
        return blogInfoService.getList();
    }
}
