package com.xingying.shopping.mas.service;

import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.UserToRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  UserToRoleService 服务类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
public interface UserToRoleService extends IService<UserToRole> {

    PageInfo<UserToRole> getListByPage(PageQueryEntity<UserToRole> params);

    /**
     * 赋角色用户
     * @param userToRoles
     * @return
     */
    boolean updateUserToRole(Set<UserToRole> userToRoles);
}
