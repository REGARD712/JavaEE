package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.common.exception.BlogException;
import com.blog.common.util.BeanTransUtils;
import com.blog.mapper.BlogInfoMapper;
import com.blog.pojo.dataobject.BlogInfo;
import com.blog.pojo.request.AddBlogRequest;
import com.blog.pojo.response.BlogInfoResponse;
import com.blog.pojo.response.Result;
import com.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getList() {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);

        // 再将blogInfos转换为BlogListResponse
        List<BlogInfoResponse> blogInfoResponse = blogInfos.stream()
                .map(blogInfo -> BeanTransUtils.trans(blogInfo))
                .collect(Collectors.toList());
        return blogInfoResponse;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0)
                .eq(BlogInfo::getId, blogId);
        BlogInfo blogInfo = blogInfoMapper.selectOne(queryWrapper);
        return BeanTransUtils.trans(blogInfo);
    }

    @Override
    public BlogInfo getBlogInfo(Integer blogId) {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0)
                .eq(BlogInfo::getId, blogId);
        return blogInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest, blogInfo);
        try {
            Integer result = blogInfoMapper.insert(blogInfo);
            if (result == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("添加博客失败，e：{}", e.getMessage());
            throw new BlogException("内部错误，请联系管理员");
        }
    }
}
