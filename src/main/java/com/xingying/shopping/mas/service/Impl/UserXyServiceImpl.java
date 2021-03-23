package com.xingying.shopping.mas.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingying.shopping.mas.common.utils.key.SnowFakeIdGenerator;
import com.xingying.shopping.mas.dao.UserToRoleMapper;
import com.xingying.shopping.mas.entity.UserToRole;
import com.xingying.shopping.mas.common.entitys.page.PageQueryEntity;
import com.xingying.shopping.mas.entity.UserXy;
import com.xingying.shopping.mas.dao.UserXyMapper;
import com.xingying.shopping.mas.service.UserXyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-22
 */
@Service
public class UserXyServiceImpl extends ServiceImpl<UserXyMapper, UserXy> implements UserXyService {

    @Autowired
    private UserXyMapper userXyMapper;
    @Autowired
    private UserToRoleMapper userToRoleMapper;
    @Autowired
    private SnowFakeIdGenerator snowFakeIdGenerator;
    @Lazy
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public PageInfo<UserXy> getListByPage(PageQueryEntity<UserXy> pageQueryEntity) {
        PageHelper.startPage(pageQueryEntity.getPageNumber(), pageQueryEntity.getPageSize());
        List<UserXy> list = userXyMapper.getListByPage(pageQueryEntity.getData());
        return new PageInfo<>(list);
    }

    @Override
    public boolean addUser(UserXy user) {
        //先获取用户的账号并查询数据库中是否存在
        String account = user.getAccount();
        Integer count = userXyMapper.selectCount(new QueryWrapper<UserXy>().eq("ACCOUNT", account));
        Assert.isTrue(count == 0, String.format("账号[%s]已经被注册", account));
        //生成Uid
        Long uid = snowFakeIdGenerator.nextId();
        user.setUserId(uid);
        user.setDataCreateTime(LocalDateTime.now());
        user.setEnabled(1);
        user.setDeleted(0);
        user.setPasswords(bCryptPasswordEncoder.encode(user.getPasswords()));
        int insert = userXyMapper.insert(user);
        if(insert > 0){
            //设置用户未普通用户
            UserToRole userToRole = new UserToRole();
            //默认普通用户为0
            userToRole.setRoleId((long) 0);
            userToRole.setUserId(uid);
            int insert1 = userToRoleMapper.insert(userToRole);
            Assert.isTrue(insert1 > 0, "新建用户角色失败");
            return true;
        }else{
            throw new RuntimeException("新建用户失败");
        }
    }
}
