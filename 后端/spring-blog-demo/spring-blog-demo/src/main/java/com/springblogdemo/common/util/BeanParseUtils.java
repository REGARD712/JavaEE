package com.springblogdemo.common.util;

import com.springblogdemo.pojo.dataobject.BlogInfo;
import com.springblogdemo.pojo.response.BlogInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanParseUtils {
    public static BlogInfoResponse  trans(BlogInfo blogInfo) {
        if (blogInfo == null) {
            // TODO: 可以抛出异常或者返回一个默认的BlogInfoResponse对象
            return null;
        }
        BlogInfoResponse response = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo, response);
        return response;
    }
}
