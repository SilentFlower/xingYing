package com.xingying.shopping.mas.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author SiletFlower
 * @date 2021/3/18 03:08:46
 * @description
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll() //拦截所有请求,放行所有权限
                .anyRequest().authenticated()   //任意请求,认证后可访问
                .and().csrf().disable();        //防止csrf攻击
    }
}
