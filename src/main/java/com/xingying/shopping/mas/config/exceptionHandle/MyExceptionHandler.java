package com.xingying.shopping.mas.config.exceptionHandle;

import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.ResultBean;
import com.xingying.shopping.mas.common.entitys.result.ReturnCode;
import com.xingying.shopping.mas.common.utils.json.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SiletFlower
 * @date 2021/3/22 01:03:23
 * @description
 */
@ControllerAdvice
public class MyExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = null;
        String ajax = request.getHeader("X-Requested-With");
        if (StringUtils.isNotEmpty(ajax)) {
            ResultBean<String> feedback;
            if (ex instanceof IllegalArgumentException){
                feedback = new OperationResultBean<>(ReturnCode.ERROR_PARAMS_FORMAT, ex.getMessage());
            }else {
                feedback = new OperationResultBean<>(ReturnCode.ACTIVE_EXCEPTION,ex.getMessage());
            }
            try {
                response.setContentType("text/json;charset=utf-8");
                JSONUtils.output(response.getWriter(),feedback);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            //handler就是处理器适配器要执行的Handler对象(只有method)
            //解析出异常类型。
            modelAndView = new ModelAndView();
            //将错误信息传到页面
            modelAndView.addObject("message", ex.getMessage());
            //指向到错误界面
            modelAndView.setViewName("error");
        }
        if (logger.isDebugEnabled()){
            logger.debug("业务异常=>",ex);
        }

        return modelAndView;
    }

}
