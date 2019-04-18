package com.springBootDemo.mapper;

import com.springBootDemo.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by lipenghui on 2019/4/12
 **/
@Mapper
public interface CategoryMapper {
  List<Category> getAllCategories();

  int addNewCategory(Category category);

  int deleteCategoryByIds(@Param("ids") String[] ids);

  int updateCategoryById(Category category);
}
