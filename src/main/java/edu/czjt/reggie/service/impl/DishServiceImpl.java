package edu.czjt.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.czjt.reggie.dto.DishDto;
import edu.czjt.reggie.entity.Dish;
import edu.czjt.reggie.entity.DishFlavor;
import edu.czjt.reggie.mapper.DishMapper;
import edu.czjt.reggie.service.DishFlavorService;
import edu.czjt.reggie.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jinkun.tian on 2023/4/27
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    DishFlavorService dishFlavorService;

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        // 创建dto
        DishDto dishDto = new DishDto();
        // 获取dish
        Dish dish = this.getById(id);
        if (dish != null) {
            BeanUtils.copyProperties(dish, dishDto);
            // 获取flavors
            List<DishFlavor> flavors = dishFlavorService.getFlavorsByDishId(id);
            dishDto.setFlavors(flavors);
        }
        return dishDto;
    }
}
