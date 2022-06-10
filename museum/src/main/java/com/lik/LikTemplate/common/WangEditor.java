package com.lik.LikTemplate.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LIk
 * @description：wangeditor返回值
 * @date ：Created in 2021/9/7 14:48
 */

@Data
public class WangEditor {

    /**
     * errno 即错误代码，0 表示没有错误。
     */
    private Integer errno;


    /**
     * 返回图片Object，Object中包含需要包含url、alt和href三个属性,它们分别代表图片地址、图片文字说明和跳转链接,
     * alt和href属性是可选的，可以不设置或设置为空字符串,需要注意的是url是一定要填的。
     */
    private String[] data;


    public WangEditor(String[] data){
        super();
        this.errno = 0;
        this.data = data;
    }

}
