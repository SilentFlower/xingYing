package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.master.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.master.common.entitys.result.OperationResultBean;
import com.xingying.shopping.master.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.UserService;
import com.xingying.shopping.mas.entity.User;

import java.util.List;

/**
 * <p>
 * 星荧虚拟商品交易系统的用户表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-16
 */
@RestController
@RequestMapping("${xingYing.name}/user")
        public class UserController {

    @Autowired
    private UserService userService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<User>> getListByPage(@RequestBody PageQueryEntity<User> params) {
        PageInfo<User> page = userService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取星荧虚拟商品交易系统的用户表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getUserByParam")
    public QueryResultBean<User> getUser(@RequestParam String key) {
        User user = userService.getById(key);
        return new QueryResultBean<>(user);
    }

    /**
     * 新增 星荧虚拟商品交易系统的用户表
     * @param user User 对象
     * @return
     */
    @PostMapping("/addUser")
    public OperationResultBean<User> addUser(@RequestBody User user) {
        boolean b = userService.saveOrUpdate(user);
        Assert.isTrue(b,"新增失败");
        return new OperationResultBean<>(user);
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delUsers")
    public OperationResultBean<String> delUsers(@RequestParam List<String> keys) {
        boolean b = userService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }
}
