package edu.czjt.reggie.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Dish implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long categoryId;
    private double price;
    private String code;
    private String image;
    private String description;
    private Long status;
    private Long sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createUser;
    private Long updateUser;
    private Long isDeleted;
}
