package org.me.mybatis_demo.mapper;

import org.junit.jupiter.api.Test;
import org.me.mybatis_demo.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleInfoMapperXMLTest {

    @Autowired
    private ArticleInfoMapperXML articleInfoMapperXML;

    @Test
    void selectById() {
        List<ArticleInfo> articleInfos = articleInfoMapperXML.selectById(1);
        System.out.println(articleInfos);
    }
}