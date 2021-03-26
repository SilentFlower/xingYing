package com.xingying.shopping.mas.config.security.handler;

import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.ReturnCode;
import com.xingying.shopping.mas.common.utils.json.JSONUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SiletFlower
 * @date 2021/3/26 08:48:08
 * @description
 */
public class AuthenticationFailHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String msg = "";
        if (e instanceof DisabledException) {
            msg = "用户被禁止";
        } else if (e instanceof BadCredentialsException) {
            msg = "用户名或密码错误";
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        JSONUtils.output(httpServletResponse.getWriter(), new OperationResultBean<>(ReturnCode.LOGIN_FAIL, msg));
    }
}
