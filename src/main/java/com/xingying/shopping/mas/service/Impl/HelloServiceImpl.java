package com.xingying.shopping.mas.service.Impl;

import com.xingying.shopping.mas.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author SiletFlower
 * @date 2021/3/14 16:10:37
 * @description
 */
@Service
@Component
@org.apache.dubbo.config.annotation.DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "你好我是主系统";
    }
}
