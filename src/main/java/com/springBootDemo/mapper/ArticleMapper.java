package com.springBootDemo.mapper;

import com.springBootDemo.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;

/**
 * created by lipenghui on 2019/4/15
 **/
@Mapper
public interface ArticleMapper {
  int addNewArticle(Article article);

  int updateArticle(Article article);

  int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

  List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid, @Param("keywords") String keywords);

  Article getArticleById(Long aid);

  void pvIncrement(Long aid);

  int updateArticleState(@Param("aids") Long aids[], @Param("state") Integer state);

  int deleteAritcleById(@Param("aids") Long aids[]);
}
