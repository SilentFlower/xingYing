package com.xingying.shopping.mas.dao;

import com.xingying.shopping.mas.entity.UserToRole;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@Repository
public interface UserToRoleMapper extends BaseMapper<UserToRole> {

    List<UserToRole> getListByPage(UserToRole userToRole);
}
