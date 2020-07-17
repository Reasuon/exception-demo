package org.reasuon.example.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Reasuon reasuon@foxmail.com
 * @since 2020/7/17
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping(value = "/checkNullP", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String checkNullP() {
        String s = null;
        String sS = s.toString();
        return sS;
    }

    @RequestMapping(value = "/checkZeroDivide", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int checkZeroDivide(int i){
        return i/0;
    }
}
