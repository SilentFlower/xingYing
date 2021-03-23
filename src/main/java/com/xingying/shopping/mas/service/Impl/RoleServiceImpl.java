package com.xingying.shopping.mas.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.utils.key.SnowFakeIdGenerator;
import com.xingying.shopping.mas.entity.Role;
import com.xingying.shopping.mas.dao.RoleMapper;
import com.xingying.shopping.mas.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SnowFakeIdGenerator snowFakeIdGenerator;

    @Override
    public PageInfo<Role> getListByPage(PageQueryEntity<Role> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<Role> list = roleMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }

    @Override
    public boolean addRole(Role role) {
        if(role.getRoleId() == null){
            role.setRoleId(snowFakeIdGenerator.nextId());
        }
        role.setDataCreateTime(LocalDateTime.now());
        //需要
        role.setCreatedBy("测试");
        boolean b = this.saveOrUpdate(role);
        return b;
    }
}
