package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.me.mybatisexample.model.ArticleInfo;

@Mapper
public interface ArticleInfoMapper {
    @Select("SELECT ta.id, ta.title, ta.content, ta.uid, tb.username, tb.age, tb.gender " +
            "FROM articleinfo ta LEFT JOIN user_info tb ON ta.uid = tb.id " +
            "WHERE ta.id = #{id}")
    ArticleInfo queryUserById(Integer id);
}
