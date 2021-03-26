package com.xingying.shopping.mas.config.security.handler;

import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;
import com.xingying.shopping.mas.common.entitys.result.ReturnCode;
import com.xingying.shopping.mas.common.utils.json.JSONUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SiletFlower
 * @date 2021/3/26 08:43:32
 * @description
 */
//未登录回调
@Service
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;chatset=utf-8");
        JSONUtils.output(httpServletResponse.getWriter(),new QueryResultBean<>(ReturnCode.NOT_LOGGED_IN, e.getMessage()));
    }
}
