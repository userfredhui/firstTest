package com.springBootDemo.controller;

import com.springBootDemo.bean.Article;
import com.springBootDemo.bean.RespBean;
import com.springBootDemo.service.ArticleService;
import com.springBootDemo.utils.Util;
import javafx.beans.binding.ObjectExpression;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * created by lipenghui on 2019/4/15
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

  private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

  @Autowired
  ArticleService articleService;
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public RespBean addNewArticle(Article article) {
    int result = articleService.addNewArticle(article);
    if (result == 1) {
      return new RespBean("0", article.getId() + "");
    } else {
      return new RespBean("1", article.getState() == 0 ? "文章保存失败" : "文章发表失败");
    }
  }

  /**
   * 上传图片
   * @param req
   * @param image
   * @return
   */
  @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
  public RespBean uploadImg(HttpServletRequest req, MultipartFile image) {
    StringBuffer url = new StringBuffer();
    String filePath = "/blogimg/" + sdf.format(new Date());
    String imgFloderPath = req.getServletContext().getRealPath(filePath);
    File imgFolder = new File(imgFloderPath);
    if (!imgFolder.exists()) {
      imgFolder.mkdirs();
    }
    url.append(req.getScheme())
            .append("://")
            .append(req.getServerName())
            .append(":")
            .append(req.getServerPort())
            .append(req.getContextPath())
            .append(filePath);
    String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
    try {
      IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
      url.append("/").append(imgName);
      return new RespBean("0", "上传图片成功", url.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new RespBean("error", "上传失败！");
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public RespBean getArticleByState(@RequestParam(value = "state", defaultValue="-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count, String keywords) {
    List<Article> articles = articleService.getArticleByState(state, page, count, keywords);
    int totalCount = articleService.getArticleCountByState(state, Util.getCurrentUser().getId(), keywords);
    Map<String, Object> map = new HashMap<>();
    map.put("totalCount", totalCount);
    map.put("articles", articles);
    return new RespBean("0", "", map);
  }

  @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
  public RespBean getArticleById(@PathVariable Long aid) {
    return new RespBean("0", "", articleService.getArticleById(aid));
  }

  @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
  public RespBean updateArticleState(Long[] aids, Integer state) {
    if (articleService.updateArticleState(aids, state) == aids.length) {
      return new RespBean("0", "删除成功");
    } else {
      return new RespBean("1", "删除失败");
    }
  }
}
