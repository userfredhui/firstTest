package com.springBootDemo.controller.admin;

import com.springBootDemo.bean.Article;
import com.springBootDemo.bean.RespBean;
import com.springBootDemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by lipenghui on 2019/4/17
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  ArticleService articleService;

  @RequestMapping(value = "/article/all", method = RequestMethod.GET)
  public RespBean getArticleByStateByAdmin(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "10") Integer count, String keywords) {
    List<Article> articles = articleService.getArticleByState(-2, page, count, keywords);
    Map<String, Object> map = new HashMap<>();
    map.put("articles", articles);
    map.put("totalCount", articleService.getArticleCountByState(1, null, keywords));
    return  new RespBean("0", "", map);
  }
}
