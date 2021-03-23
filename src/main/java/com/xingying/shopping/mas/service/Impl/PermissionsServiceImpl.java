package com.xingying.shopping.mas.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.common.utils.key.SnowFakeIdGenerator;
import com.xingying.shopping.mas.entity.Permissions;
import com.xingying.shopping.mas.dao.PermissionsMapper;
import com.xingying.shopping.mas.service.PermissionsService;
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
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;
    @Autowired
    private SnowFakeIdGenerator snowFakeIdGenerator;

    @Override
    public PageInfo<Permissions> getListByPage(PageQueryEntity<Permissions> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<Permissions> list = permissionsMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }

    @Override
    public boolean addPermissions(Permissions permissions) {
        if (permissions.getPermissionsId() == null) {
            permissions.setPermissionsId(snowFakeIdGenerator.nextId());
        }
        permissions.setDataCreateTime(LocalDateTime.now());
        boolean b = this.saveOrUpdate(permissions);
        return b;
    }
}
