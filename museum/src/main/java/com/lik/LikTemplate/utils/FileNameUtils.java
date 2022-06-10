package com.lik.LikTemplate.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author ：LIkxuyao
 * @description：
 * @date ：Created in 2021/9/8 10:36
 */
public class FileNameUtils {


    /**
     * 随机文件名
     * @return
     */
    public static String getFileName(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(new Date())+"/"+getSixNum();
    }

    public static String getSixNum() {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 6; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }






}
