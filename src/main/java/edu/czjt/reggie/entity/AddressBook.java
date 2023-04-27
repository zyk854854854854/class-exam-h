package edu.czjt.reggie.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddressBook implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String consignee;
    private Long sex;
    private String phone;
    private String provinceCode;
    private String provinceName;
    private String cityCode;
    private String cityName;
    private String districtCode;
    private String districtName;
    private String detail;
    private String label;
    private Long isDefault;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createUser;
    private Long updateUser;
    private Long isDeleted;

}
