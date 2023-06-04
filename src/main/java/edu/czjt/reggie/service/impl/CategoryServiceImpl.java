package edu.czjt.reggie.service.impl;

import edu.czjt.reggie.mapper.Category;
import edu.czjt.reggie.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }
}