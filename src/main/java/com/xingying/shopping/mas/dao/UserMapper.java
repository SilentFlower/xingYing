package com.xingying.shopping.mas.dao;

import com.xingying.shopping.mas.entity.User;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-16
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getListByPage(User user);
}
