package edu.czjt.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.czjt.reggie.entity.DishFlavor;
import edu.czjt.reggie.mapper.DishFlavorMapper;
import edu.czjt.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * Created by jinkun.tian on 2023/4/27
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
