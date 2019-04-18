package com.springBootDemo.controller;

import com.springBootDemo.bean.Category;
import com.springBootDemo.bean.RespBean;
import com.springBootDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by lipenghui on 2019/4/12
 **/

/**
 * 超级管理员专属的Controller
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
  @Autowired
  CategoryService categoryService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public RespBean getAllCategories() {
    return new RespBean("0", "", categoryService.getAllCategories());
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public RespBean addNewCategory(Category category) {
    int result = categoryService.addNewCategory(category);
    if (result == 1) {
      return new RespBean("0","", "添加成功");
    }
    return new RespBean("1","", "添加失败");
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public RespBean updateCategoryById(Category category) {
    int i = categoryService.updateCategoryById(category);
    if (i == 1) {
      return new RespBean("0", "");
    } else {
      return new RespBean("1", "修改失败");
    }
  }

  @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
  public RespBean deleteByIds(@PathVariable String ids) {
    boolean result = categoryService.deleteCategoryByIds(ids);
    if (result) {
      return new RespBean("0", "");
    } else {
      return new RespBean("1", "删除失败");
    }
  }
}
