package edu.czjt.reggie.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DishFlavor implements Serializable {
  private static final Long serialVersionUID = 1L;
  private Long id;
  private Long dishId;
  private String name;
  private String value;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private Long createUser;
  private Long updateUser;
  private Long isDeleted;
}
