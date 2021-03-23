package com.xingying.shopping.mas.service;

import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.PermissionsToRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  PermissionsToRoleService 服务类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
public interface PermissionsToRoleService extends IService<PermissionsToRole> {

    PageInfo<PermissionsToRole> getListByPage(PageQueryEntity<PermissionsToRole> params);

    /**
     * 为角色授权资源
     * @param permissionsToRole
     * @return
     */
    boolean updatePermissionsToRole(Set<PermissionsToRole> permissionsToRole);
}
