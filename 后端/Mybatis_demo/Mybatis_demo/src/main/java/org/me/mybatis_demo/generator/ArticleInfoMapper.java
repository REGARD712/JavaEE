package org.me.mybatis_demo.generator;

import java.util.List;
import org.me.mybatis_demo.generator.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    List<ArticleInfo> selectAll();

    int updateByPrimaryKey(ArticleInfo record);
}