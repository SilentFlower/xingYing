package com.xingying.shopping.mas.service;

import com.github.pagehelper.PageInfo;
import com.xingying.shopping.master.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  UserService 服务类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-16
 */
public interface UserService extends IService<User> {

    PageInfo<User> getListByPage(PageQueryEntity<User> params);
}
