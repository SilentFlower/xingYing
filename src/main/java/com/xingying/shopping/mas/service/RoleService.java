package com.xingying.shopping.mas.service;

import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  RoleService 服务类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
public interface RoleService extends IService<Role> {

    PageInfo<Role> getListByPage(PageQueryEntity<Role> params);

    /**
     * 新增或修改角色表
     * @param role
     * @return
     */
    boolean addRole(Role role);
}
