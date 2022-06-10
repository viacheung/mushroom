package com.lik.LikTemplate.handler;

import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：LiK
 * @date ：2021/7/25 8:38 上午
 * 统一异常处理,当系统出现异常时会调用这个方法返回
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        log.error(ExceptionUtils.getMessage(e));
        return Result.error();
    }


}
