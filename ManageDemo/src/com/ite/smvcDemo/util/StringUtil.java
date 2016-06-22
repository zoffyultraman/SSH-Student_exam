package com.ite.smvcDemo.util;

import java.text.MessageFormat;

/**
 * StringUtil
 * @author Alex
 * @CreateTime 2015-09-14
 */
public class StringUtil {

    /**
     * Replace the arguments in the text
     *
     * @param pattern
     *            text pattern
     * @param arguments
     *            values of the arguments
     * @return the replaced string
     */
    public static String rtp(String pattern, Object[] arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    /**
     * Test the string is null or blank.
     *
     * @param str
     *            the tested string
     * @return if string is null or blank, then true; else flase;
     */
    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim()))
            return true;
        return false;
    }

}
