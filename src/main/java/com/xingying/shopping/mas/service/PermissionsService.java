package com.xingying.shopping.mas.service;

import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.Permissions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  PermissionsService 服务类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
public interface PermissionsService extends IService<Permissions> {

    PageInfo<Permissions> getListByPage(PageQueryEntity<Permissions> params);

    /**
     * 新增或修改
     * @param permissions
     * @return
     */
    boolean addPermissions(Permissions permissions);
}
