package org.reasuon.example.exception.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 全局Controller变量统一处理.
 * {@code @ControllerAdvice} 标签只注册了 Controller.class<br>
 * 那么 @RestController 的 controller 抛出就无法被该类监听到
 *
 * @author Reasuon reasuon@gmail.com
 * @since 2020/7/17
 */
@ControllerAdvice(annotations = Controller.class)
public class ExceptionHandleExe {

    /**
     * 处理所有的Controller层面的异常
     * */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handleAllExceptions(Exception e, HttpServletRequest request){
        //获取触发异常的Controller的请求地址
        System.out.println("URL: " + request.getRequestURI());
        //获取触发异常的请求参数
        Enumeration<String> es = request.getParameterNames();
        String param = "";
        while (es.hasMoreElements()) {
            param = es.nextElement();
            System.out.println("param: " + param + ", value: " + request.getParameter(param));
        }
        //输出异常的Message
        System.out.println(e.getMessage());
        if (e instanceof NullPointerException) {
            return "空指针异常!<--全局异常处理结果";
        } else {
            return "异常类型未知!<--全局异常处理结果";
        }
    }
}
