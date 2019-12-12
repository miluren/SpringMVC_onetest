package z.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 把字符串转换成日期
* */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    /*
    * String s 传入进来字符串
    *
    * */
    public Date convert(String s) {
        //判断
        if(s == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        字符串转换成日期
        try {
            return  df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");
        }

    }
}
