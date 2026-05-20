package org.me.mybatis_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.me.mybatis_demo.model.ArticleInfo;

import java.util.List;

@Mapper
public interface ArticleInfoMapperXML {
    List<ArticleInfo> selectById(Integer id);
}
