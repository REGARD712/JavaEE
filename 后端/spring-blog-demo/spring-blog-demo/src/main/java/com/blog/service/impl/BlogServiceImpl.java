package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.common.util.BeanParseUtils;
import com.blog.mapper.BlogInfoMapper;
import com.blog.pojo.dataobject.BlogInfo;
import com.blog.pojo.response.BlogInfoResponse;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .map(blogInfo -> BeanParseUtils.trans(blogInfo))
                .collect(Collectors.toList());
        return blogInfoResponse;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0)
                .eq(BlogInfo::getId, blogId);
        BlogInfo blogInfo = blogInfoMapper.selectOne(queryWrapper);
        return BeanParseUtils.trans(blogInfo);
    }
}
