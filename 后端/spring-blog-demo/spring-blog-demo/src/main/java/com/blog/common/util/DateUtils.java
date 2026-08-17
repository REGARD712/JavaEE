package com.blog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
