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
public class UserToRoleServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements UserToRoleService {

    @Autowired
    private UserToRoleMapper userToRoleMapper;

    @Override
    public PageInfo<UserToRole> getListByPage(PageQueryEntity<UserToRole> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<UserToRole> list = userToRoleMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }
}
