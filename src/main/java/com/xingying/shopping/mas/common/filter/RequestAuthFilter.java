//package com.xingying.shopping.mas.common.filter;
//
//import com.alibaba.druid.support.json.JSONUtils;
//import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * 认证操作
// */
//@Component
//public class RequestAuthFilter implements Filter {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Value("${xingYing.master.connect}")
//    private Boolean masterConnect;
//    @Value("${xingYing.master.name}")
//    private String masterHost;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//         if (servletRequest instanceof HttpServletRequest){
//             //如果配置没有连接主系统，则直接过认证
//             if (!masterConnect){
//                 filterChain.doFilter(servletRequest,servletResponse);
//                 return;
//             }
//            // 以下伪代码
//            String token = ((HttpServletRequest) servletRequest).getHeader("X-token");
//            String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
//            HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.add("X-token", token);
//            requestHeaders.add("X-Requested-With", "X-Requested-With");
//            requestHeaders.add("slave", "1");
//            RestTemplate template = new RestTemplate();
//            HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
//            ResponseEntity<String> response = template.exchange(masterHost+requestURI, HttpMethod.GET, requestEntity, String.class);
//            HttpStatus statusCode = response.getStatusCode();
//            if (statusCode.is2xxSuccessful()){
//                String responseBody = response.getBody();
//                QueryResultBean<String> resultBean = JSONUtils.toBean(responseBody, QueryResultBean.class);
//                if (resultBean.getCode() == 10000){
//                    logger.debug("身份认证成功");
//                    UserContext.setCurrentUser(JSONUtils.toBean(JSONUtils.toString(resultBean.getData()),SimpleHisUser.class));
//                    filterChain.doFilter(servletRequest,servletResponse);
//                }else {
//                    logger.debug("身份认证失败 ===> {}",responseBody);
//                    servletResponse.setContentType("application/json;charset=utf-8");
//                    servletResponse.getWriter().write(responseBody);
//                    return;
//                }
//            }
//
//        }
//        UserContext.clearCurrentUser();
//    }
//
//}
