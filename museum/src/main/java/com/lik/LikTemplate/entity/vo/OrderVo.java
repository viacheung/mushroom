package com.lik.LikTemplate.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVo {

    private String oid;

    private String zName;

    private String price;

    private String uName;

    private Date time;

    private String state;

}
