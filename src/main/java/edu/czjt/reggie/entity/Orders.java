package edu.czjt.reggie.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import java.time.LocalDateTime;

@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String number;
    private Long status;
    private Long userId;
    private Long addressBookId;
    private LocalDateTime orderTime;
    private LocalDateTime checkoutTime;
    private Long payMethod;
    private BigDecimal amount;
    private String remark;
    private String phone;
    private String address;
    private String userName;
    private String consignee;

}
