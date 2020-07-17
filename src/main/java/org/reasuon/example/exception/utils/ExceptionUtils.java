package org.reasuon.example.exception.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Reasuon reasuon@foxmail.com
 * @since 2020/7/17
 */
public class ExceptionUtils {

    public static String getExceptionSrintStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
