package com.xingying.shopping.mas.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.utils.key.SnowFakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.entitys.result.OperationResultBean;
import com.xingying.shopping.mas.common.entitys.result.QueryResultBean;

import com.xingying.shopping.mas.service.PermissionsService;
import com.xingying.shopping.mas.entity.Permissions;

import java.util.List;

/**
 * <p>
 * 星荧虚拟商品交易网站的权限表 前端控制器
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@RestController
@RequestMapping("${xingYing.name}/permissions")
        public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    /**
    * 分页列表
    *
    * @param params   分页信息
    * @return Result
    */
    @PostMapping("/getListByPage")
    public QueryResultBean<PageInfo<Permissions>> getListByPage(@RequestBody PageQueryEntity<Permissions> params) {
        PageInfo<Permissions> page = permissionsService.getListByPage(params);
        return new QueryResultBean<>(page);
    }

    /**
     * 获取星荧虚拟商品交易网站的权限表
     *
     * @param key
     * @return Result
     */
    @GetMapping("/getPermissionsByParam")
    public QueryResultBean<Permissions> getPermissions(@RequestParam String key) {
        Permissions permissions = permissionsService.getById(key);
        return new QueryResultBean<>(permissions);
    }

    /**
     * 新增 星荧虚拟商品交易网站的权限表
     * @param permissions Permissions 对象
     * @return
     */
    @PostMapping("/addPermissions")
    public OperationResultBean<Permissions> addPermissions(@RequestBody Permissions permissions) {
        boolean b = permissionsService.addPermissions(permissions);
        Assert.isTrue(b,"新增失败");
        return new OperationResultBean<>(permissions);
    }

    /**
     * 删除
     *
     * @param keys key字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delPermissionss")
    public OperationResultBean<String> delPermissionss(@RequestParam List<String> keys) {
        boolean b = permissionsService.removeByIds(keys);
        Assert.isTrue(b, "删除失败");
        return new OperationResultBean<>("success");
    }
}
