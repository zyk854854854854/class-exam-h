package edu.czjt.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.czjt.reggie.entity.Dish;
import edu.czjt.reggie.mapper.DishMapper;
import edu.czjt.reggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * Created by jinkun.tian on 2023/4/27
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
