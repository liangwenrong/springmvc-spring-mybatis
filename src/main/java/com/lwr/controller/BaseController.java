package com.lwr.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基准控制器
 */
public class BaseController {
    /**
     * 时间转换
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
            private static final long serialVersionUID = 1L;
            private String[] patterns = new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm" };

            /*
             * 对请求参数中的时间格式进行转换
             */
            public Date parse(String source) throws ParseException {
                try {
                    if (source == null || "".equals(source)) {
                        return null;
                    }
                    if (toPattern().length() == source.length())
                        return super.parse(source);
                    for (int i = 0; i < patterns.length; i++) {
                        if (patterns[i].length() == source.length()) {
                            applyPattern(patterns[i]);// 修改应用新格式
                            return super.parse(source);
                        }
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }, false);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping("*")
    public String pageNotFound() {
        return "404";
    }

}
