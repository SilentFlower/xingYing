package com.xingying.shopping.mas.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.PermissionsToRole;
import com.xingying.shopping.mas.dao.PermissionsToRoleMapper;
import com.xingying.shopping.mas.service.PermissionsToRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
public class PermissionsToRoleServiceImpl extends ServiceImpl<PermissionsToRoleMapper, PermissionsToRole> implements PermissionsToRoleService {

    @Autowired
    private PermissionsToRoleMapper permissionsToRoleMapper;

    @Override
    public PageInfo<PermissionsToRole> getListByPage(PageQueryEntity<PermissionsToRole> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<PermissionsToRole> list = permissionsToRoleMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePermissionsToRole(Set<PermissionsToRole> permissionsToRole) {
        //获取角色ID
        Set<Long> collect = permissionsToRole.stream().map(PermissionsToRole::getRoleId).collect(Collectors.toSet());
        //清空中间表关于角色ID的内容，再重新插入
        this.removeByIds(collect);
        boolean b = this.saveBatch(permissionsToRole);
        return b;
    }
}
