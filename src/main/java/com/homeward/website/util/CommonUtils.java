package com.homeward.website.util;

import com.homeward.website.enums.BaseEnum;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 一些其他的工具整合的类
 */
public class CommonUtils {

    public static String currentFormattedDate(BaseEnum baseEnum) {
        return new SimpleDateFormat(baseEnum.getMessage())
                .format(Calendar.getInstance().getTime());
    }

    public static void throwRuntimeException(BaseEnum baseEnum) {
        throw new RuntimeException(baseEnum.getMessage());
    }
}
