package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.PermissionsToRoleService;
import com.xingying.shopping.mas.entity.PermissionsToRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 星荧虚拟商品交易系统的权限表和角色表的映射表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@RestController
@RequestMapping("${xingYing.name}/permissionsToRole")
        public class PermissionsToRoleController {

    @Autowired
    private PermissionsToRoleService permissionsToRoleService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<PermissionsToRole>> getListByPage(@RequestBody PageQueryEntity<PermissionsToRole> params) {
        PageInfo<PermissionsToRole> page = permissionsToRoleService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取星荧虚拟商品交易系统的权限表和角色表的映射表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getPermissionsToRoleByParam")
    public QueryResultBean<PermissionsToRole> getPermissionsToRole(@RequestParam String key) {
        PermissionsToRole permissionsToRole = permissionsToRoleService.getById(key);
        return new QueryResultBean<>(permissionsToRole);
    }

    /**
     * 新增 星荧虚拟商品交易系统的权限表和角色表的映射表
     * @param permissionsToRole PermissionsToRole 对象
     * @return
     */
    @PostMapping("/addPermissionsToRole")
    public OperationResultBean<PermissionsToRole> addPermissionsToRole(@RequestBody PermissionsToRole permissionsToRole) {
        boolean b = permissionsToRoleService.saveOrUpdate(permissionsToRole);
        Assert.isTrue(b,"新增失败");
        return new OperationResultBean<>(permissionsToRole);
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delPermissionsToRoles")
    public OperationResultBean<String> delPermissionsToRoles(@RequestParam List<String> keys) {
        boolean b = permissionsToRoleService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }


    /**
     * 角色授权资源
     * @param permissionsToRole
     * @return
     */
    @PostMapping("/updatePermissionsToRole")
    public OperationResultBean<String> updatePermissionsToRole(@RequestBody Set<PermissionsToRole> permissionsToRole) {
        Assert.notEmpty(permissionsToRole, "授权为空");
        boolean b = permissionsToRoleService.updatePermissionsToRole(permissionsToRole);
        Assert.isTrue(b, "授权失败");
        if (b) {
            //清除当前授权的表,加载新的授权
        }
        return new OperationResultBean<>("授权成功");
    }
}
