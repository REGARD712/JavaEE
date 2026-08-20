package com.blog.common.util;

import com.blog.pojo.dataobject.BlogInfo;
import com.blog.pojo.dataobject.UserInfo;
import com.blog.pojo.request.UpdateBlogRequest;
import com.blog.pojo.response.BlogInfoResponse;
import com.blog.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTransUtils {
    public static BlogInfoResponse  trans(BlogInfo blogInfo) {
        if (blogInfo == null) {
            // TODO: 可以抛出异常或者返回一个默认的BlogInfoResponse对象
            return null;
        }
        BlogInfoResponse response = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo, response);
        return response;
    }

    public static UserInfoResponse trans(UserInfo userInfo) {
        if (userInfo == null) {
            // TODO: 可以抛出异常或者返回一个默认的UserInfoResponse对象
            return null;
        }
        UserInfoResponse response = new UserInfoResponse();
        BeanUtils.copyProperties(userInfo, response);
        return response;
    }

    public static BlogInfo trans(UpdateBlogRequest updateBlogRequest) {
        if (updateBlogRequest == null) {
            // TODO: 可以抛出异常或者返回一个默认的BlogInfo对象
            return null;
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest, blogInfo);
        return blogInfo;
    }
}
