package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.UserXyService;
import com.xingying.shopping.mas.entity.UserXy;

import java.util.List;

/**
 * <p>
 * 星荧虚拟商品交易系统的用户表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-22
 */
@RestController
@RequestMapping("${xingYing.name}/user")
        public class UserXyController {

    @Autowired
    private UserXyService userXyService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<UserXy>> getListByPage(@RequestBody PageQueryEntity<UserXy> params) {
        PageInfo<UserXy> page = userXyService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取星荧虚拟商品交易系统的用户表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getUserByParam")
    public QueryResultBean<UserXy> getUserXy(@RequestParam String key) {
        UserXy userXy = userXyService.getById(key);
        return new QueryResultBean<>(userXy);
    }

    /**
     * 新增 星荧虚拟商品交易系统的用户表
     * @param user UserXy 对象
     * @return
     */
    @PostMapping("/addUser")
    public OperationResultBean<String> addUserXy(@RequestBody UserXy user) {
        boolean b = userXyService.addUser(user);
        Assert.isTrue(b,"注册失败");
        return new OperationResultBean<>("success");
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delUsers")
    public OperationResultBean<String> delUserXys(@RequestParam List<String> keys) {
        boolean b = userXyService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }
}
