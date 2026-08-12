package com.springblogdemo.controller;

import com.springblogdemo.pojo.response.BlogInfoResponse;
import com.springblogdemo.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList() {
        log.info("获取博客列表");

        List<BlogInfoResponse> blogInfos = blogService.getList();
        return blogInfos;
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail (@NotNull Integer blogId) {
        log.info("获取博客详情，blogId: {}", blogId);
        // TODO: 这里可以增加参数校验，判断blogId是否为空或小于等于0
        return blogService.getBlogDetail(blogId);
    }
}
