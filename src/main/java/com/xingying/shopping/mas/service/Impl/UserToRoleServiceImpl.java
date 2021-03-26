package com.xingying.shopping.mas.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.UserToRole;
import com.xingying.shopping.mas.dao.UserToRoleMapper;
import com.xingying.shopping.mas.service.UserToRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@Service
public class UserToRoleServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements UserToRoleService {

    @Autowired
    private UserToRoleMapper userToRoleMapper;

    @Override
    public PageInfo<UserToRole> getListByPage(PageQueryEntity<UserToRole> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<UserToRole> list = userToRoleMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserToRole(Set<UserToRole> userToRoles) {
        Set<Long> collect = userToRoles.stream().map(UserToRole::getUserId).collect(Collectors.toSet());
        this.removeByIds(collect);
        boolean b = this.saveBatch(userToRoles);
        return b;
    }
}
