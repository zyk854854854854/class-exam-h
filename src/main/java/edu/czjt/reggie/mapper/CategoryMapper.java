package edu.czjt.reggie.mapper;

import edu.czjt.reggie.mapper.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getCategoryById(Long id);

    @Insert("INSERT INTO category (name) VALUES (#{name})")
    void createCategory(Category category);

    @Update("UPDATE category SET name = #{name} WHERE id = #{id}")
    void updateCategory(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteCategory(Long id);

    @Select("SELECT * FROM category")
    List<Category> getAllCategories();

    List<Category> list();
}