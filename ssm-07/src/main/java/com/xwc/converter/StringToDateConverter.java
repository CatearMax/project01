package com.xwc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-04-12 14:41
 * @name StringToDateConverter
 * @description String转换成Date类型
 */
public class StringToDateConverter implements Converter<String,Date> {


    /**
     * 将接收的String类型转换成Date类型
     * @param source 接收到的String类型时间
     * @return 转换后的Date类型
     */
    @Override
    public Date convert(String source) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //若格式错误则返回当前时间
       // Date date = new Date();
        Date date = null;
        try {
            //对传入的时间进行解析
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
