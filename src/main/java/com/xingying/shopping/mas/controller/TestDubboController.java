package com.xingying.shopping.mas.controller;

import com.xingying.shopping.mas.config.dubbo.DubboHost;
import com.xingying.shopping.mas.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SiletFlower
 * @date 2021/3/14 16:19:22
 * @description
 */
@RestController
public class TestDubboController {
    @DubboReference(url = DubboHost.xingYingHost,lazy = true)
    private HelloService helloService;

    @RequestMapping("/")
    public String test(HttpServletRequest httpServletRequest){
        String s = helloService.sayHello("测试");
        System.out.println(s);
        return s;
    }


}
