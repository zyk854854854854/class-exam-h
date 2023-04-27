package edu.czjt.reggie.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Category implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private Integer type;
    private String name;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createUser;
    private Long updateUser;


}
