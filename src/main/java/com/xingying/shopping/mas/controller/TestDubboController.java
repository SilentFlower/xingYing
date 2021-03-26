package com.xingying.shopping.mas.controller;

import com.xingying.shopping.mas.config.dubbo.DubboHost;
import com.xingying.shopping.master.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author SiletFlower
 * @date 2021/3/14 16:19:22
 * @description
 */
@RestController
public class TestDubboController {
    @DubboReference(url = DubboHost.test,lazy = true)
    private HelloService helloService;

    @RequestMapping("/")
    public String test(HttpServletRequest httpServletRequest){
        String s = helloService.sayHello("测试");
        System.out.println(s);
        return s;
    }

    @RequestMapping("/session")
    public String test02(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "测试");
        return session.getId();
    }

    @RequestMapping("/getSession")
    public String test03(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getId());
        return session.getId();
    }


}
