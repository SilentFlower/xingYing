package com.xingying.shopping.mas.dao;

import com.xingying.shopping.mas.entity.PermissionsToRole;
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
public interface PermissionsToRoleMapper extends BaseMapper<PermissionsToRole> {

    List<PermissionsToRole> getListByPage(PermissionsToRole permissionsToRole);
}
