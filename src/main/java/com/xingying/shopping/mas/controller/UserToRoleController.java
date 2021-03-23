package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.UserToRoleService;
import com.xingying.shopping.mas.entity.UserToRole;

import java.util.List;

/**
 * <p>
 * 用户与角色的映射表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@RestController
@RequestMapping("${xingYing.name}/userToRole")
        public class UserToRoleController {

    @Autowired
    private UserToRoleService userToRoleService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<UserToRole>> getListByPage(@RequestBody PageQueryEntity<UserToRole> params) {
        PageInfo<UserToRole> page = userToRoleService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取用户与角色的映射表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getUserToRoleByParam")
    public QueryResultBean<UserToRole> getUserToRole(@RequestParam String key) {
        UserToRole userToRole = userToRoleService.getById(key);
        return new QueryResultBean<>(userToRole);
    }

    /**
     * 新增 用户与角色的映射表
     * @param userToRole UserToRole 对象
     * @return
     */
    @PostMapping("/addUserToRole")
    public OperationResultBean<UserToRole> addUserToRole(@RequestBody UserToRole userToRole) {
        boolean b = userToRoleService.saveOrUpdate(userToRole);
        Assert.isTrue(b,"新增失败");
        return new OperationResultBean<>(userToRole);
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delUserToRoles")
    public OperationResultBean<String> delUserToRoles(@RequestParam List<String> keys) {
        boolean b = userToRoleService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }
}
