package edu.czjt.reggie.entity;


import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SetmealDish implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String setmealId;
    private String dishId;
    private String name;
    private BigDecimal price;
    private Long copies;
    private Long sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createUser;
    private Long updateUser;
    private Long isDeleted;
}
