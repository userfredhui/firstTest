package com.springBootDemo.service;

import com.springBootDemo.bean.Category;
import com.springBootDemo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * created by lipenghui on 2019/4/12
 **/
@Service
@Transactional
public class CategoryService {
  @Autowired
  CategoryMapper categoryMapper;

  public List<Category> getAllCategories() {
    return categoryMapper.getAllCategories();
  }

  public int addNewCategory(Category category) {
    category.setDate(new Timestamp(System.currentTimeMillis()));
    return categoryMapper.addNewCategory(category);
  }

  public Boolean deleteCategoryByIds(String ids) {
    String[] split = ids.split(",");
    int result = categoryMapper.deleteCategoryByIds(split);
    return result == split.length;
  }

  public int updateCategoryById(Category category) {
    return categoryMapper.updateCategoryById(category);
  }
}
