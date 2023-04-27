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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinkun.tian on 2023/4/21
 */
@Slf4j
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
        //构造查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        //添加条件，查询状态为1（起售状态）的菜品
        queryWrapper.eq(Dish::getStatus, 1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(queryWrapper);
        // 填充dishDto，填充CategoryName和dishFlavor
        List<DishDto> dishDtoList = list.stream().map((item) -> {
            // 创建DishDto
            DishDto dishDto = new DishDto();
            // 将item数据拷贝到DishDto中
            BeanUtils.copyProperties(item, dishDto);
            // 获取CategoryName
            Category category = categoryService.getById(item.getCategoryId());
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            // 获取DishFlavor
            LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(DishFlavor::getDishId, item.getId());

            List<DishFlavor> dishFlavors = dishFlavorService.list(lambdaQueryWrapper);

            dishDto.setFlavors(dishFlavors);

            return dishDto;
        }).collect(Collectors.toList());

        return R.success(dishDtoList);
    }

}
