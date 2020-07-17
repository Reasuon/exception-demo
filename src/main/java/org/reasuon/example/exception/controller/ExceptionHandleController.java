package org.reasuon.example.exception.controller;

import org.reasuon.example.exception.utils.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author Reasuon reasuon@gmail.com
 * @since 2020/7/17
 */
@Controller
@RequestMapping("/exceptionHandle")
public class ExceptionHandleController {

    @RequestMapping(value = "/checkNullP", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String checkNullP() {
        String s = null;
        String sS = s.toString();
        return sS;
    }

    /**
     * 局部异常统一处理.
     * <p>只对当前Java文件内的方法有效，不过如果是server层或其他Java文件的异常抛出至这里，也生效<br>
     * 这种方式适合除了少且特殊的异常，如果是需要通用且大范围的异常处理，应该使用全局的方式来处理</p>
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String exceptionHandle(Exception e){
        if (e instanceof NullPointerException) {
            return ": 空指针异常!<--局部异常处理结果";
        } else {
            return ": 异常类型未知!<--局部异常处理结果";
        }
    }
}
