package edu.czjt.reggie.service.impl;

import edu.czjt.reggie.mapper.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long id);

    List<Category> getAllCategories();

    List<Category> list();
}