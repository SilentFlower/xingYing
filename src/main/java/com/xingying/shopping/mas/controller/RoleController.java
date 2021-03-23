package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.RoleService;
import com.xingying.shopping.mas.entity.Role;

import java.util.List;

/**
 * <p>
 * 星荧虚拟商品交易系统角色表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@RestController
@RequestMapping("${xingYing.name}/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<Role>> getListByPage(@RequestBody PageQueryEntity<Role> params) {
        PageInfo<Role> page = roleService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取星荧虚拟商品交易系统角色表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getRoleByParam")
    public QueryResultBean<Role> getRole(@RequestParam String key) {
        Role role = roleService.getById(key);
        return new QueryResultBean<>(role);
    }

    /**
     * 新增或修改角色表
     * @param role Role 对象
     * @return
     */
    @PostMapping("/addRole")
    public OperationResultBean<Role> addRole(@RequestBody Role role) {
        boolean b = roleService.addRole(role);
        Assert.isTrue(b,"新增失败");
        return new OperationResultBean<>(role);
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delRoles")
    public OperationResultBean<String> delRoles(@RequestParam List<String> keys) {
        boolean b = roleService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }
}
