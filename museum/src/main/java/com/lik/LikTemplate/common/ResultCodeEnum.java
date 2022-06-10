package com.lik.LikTemplate.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @author ：LiK
 * @date ：2021/7/23 9:35 下午
 */
@Getter
@ToString
public enum ResultCodeEnum {

    //枚举类的实例
    SUCCESS(true,20000,"成功"),
    UNKNOWN_REASON(false,20001,"未知错误"),
    ALIYUNOSS_Exception(false,20002,"阿里云OSS上传出错"),
    FILE_EXCEPTION(false,20003,"上传文件转换异常");




    private Boolean success;

    private Integer code;

    private String massage;

    ResultCodeEnum(Boolean success, Integer code, String massage){
        this.success = success;
        this.code = code;
        this.massage = massage;
    }
}
