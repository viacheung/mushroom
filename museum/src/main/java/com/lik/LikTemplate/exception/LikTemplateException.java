package com.lik.LikTemplate.exception;

import com.lik.LikTemplate.common.ResultCodeEnum;

/**
 * @author ：LiK
 * @date ：2021/7/25 8:31 上午
 * 异常类
 */

public class LikTemplateException extends RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public LikTemplateException(Integer code ,String message){
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public LikTemplateException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMassage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "LikTemplateException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }




}
