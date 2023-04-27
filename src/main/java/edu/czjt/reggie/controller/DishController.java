package edu.czjt.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.czjt.reggie.common.R;
import edu.czjt.reggie.dto.DishDto;
import edu.czjt.reggie.entity.Category;
import edu.czjt.reggie.entity.Dish;
import edu.czjt.reggie.entity.DishFlavor;
import edu.czjt.reggie.service.CategoryService;
import edu.czjt.reggie.service.DishFlavorService;
import edu.czjt.reggie.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinkun.tian on 2023/4/27
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish) {
        // 根据分类查询菜品，并且为起售的菜品
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus, 1);
        List<Dish> dishes = dishService.list(queryWrapper);

        // 遍历dishs，创建List<DishDto>
        List<DishDto> dishDtos = dishes.stream().map((item) -> {
            // 创建DishDto
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            // 补充CategoryName
            Category category = categoryService.getById(item.getCategoryId());
            if (category != null) {
                dishDto.setCategoryName(category.getName());
            }

            // 补充List<DishFlavor>
            LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
            dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, item.getId());
            List<DishFlavor> flavors = dishFlavorService.list(dishFlavorLambdaQueryWrapper);
            dishDto.setFlavors(flavors);

            return dishDto;
        }).collect(Collectors.toList());

        return R.success(dishDtos);
    }
}
