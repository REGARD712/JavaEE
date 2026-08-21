package com.blog.controller;

import com.blog.pojo.request.AddBlogRequest;
import com.blog.pojo.request.UpdateBlogRequest;
import com.blog.pojo.response.BlogInfoResponse;
import com.blog.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    /**
     * @Title: getList
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: []
     * @Return: List<BlogInfoResponse>
     * @Description: 获取博客列表
     */
    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList() {
        log.info("获取博客列表");
        List<BlogInfoResponse> blogInfos = blogService.getList();
        return blogInfos;
    }

    /**
     * @Title: getBlogDetail
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [blogId]
     * @Return: BlogInfoResponse
     * @Description: 获取博客详情
     */
    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail (@NotNull(message = "blogId不能为null") Integer blogId) {
        log.info("获取博客详情，blogId: {}", blogId);
        // TODO: 这里可以增加参数校验，判断blogId是否为空或小于等于0
        return blogService.getBlogDetail(blogId);
    }

    /**
     * @Title: add
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [addBlogRequest]
     * @Return: Boolean
     * @Description: 添加博客
     */
    @RequestMapping("/add")
    public Boolean add (@RequestBody @Validated AddBlogRequest addBlogRequest) {
        log.info("添加博客，userId: {}，title: {}", addBlogRequest.getUserId(), addBlogRequest.getTitle());
        return blogService.addBlog(addBlogRequest);
    }

    /**
     * @Title: update
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [updateBlogRequest]
     * @Return: Boolean
     * @Description: 更新博客
     */
    @RequestMapping("/update")
    public Boolean update (@RequestBody @Validated UpdateBlogRequest updateBlogRequest) {
        log.info("更新博客，updateBlogRequest: {}", updateBlogRequest);
        return blogService.updateBlog(updateBlogRequest);
    }

    /**
     * @Title: delete
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [blogId]
     * @Return: Boolean
     * @Description: 删除博客
     */
    @RequestMapping("/delete")
    public Boolean delete (@NotNull(message = "blogId不能为null") Integer blogId) {
        log.info("删除博客，blogId: {}", blogId);
        return blogService.deleteBlog(blogId);
    }
}
