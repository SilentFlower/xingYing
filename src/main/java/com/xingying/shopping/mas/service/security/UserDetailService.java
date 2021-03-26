package com.xingying.shopping.mas.service.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xingying.shopping.mas.dao.RoleMapper;
import com.xingying.shopping.mas.dao.UserToRoleMapper;
import com.xingying.shopping.mas.dao.UserXyMapper;
import com.xingying.shopping.mas.entity.Role;
import com.xingying.shopping.mas.entity.UserToRole;
import com.xingying.shopping.mas.entity.UserXy;
import com.xingying.shopping.mas.service.UserXyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SiletFlower
 * @date 2021/3/25 03:04:26
 * @description
 */
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserXyMapper userXyMapper;
    @Autowired
    private UserToRoleMapper userToRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        //根据account查询用户
        UserXy user = userXyMapper.selectOne(new QueryWrapper<UserXy>()
                .eq("ACCOUNT", account));
        if (user == null) {
            throw new UsernameNotFoundException("user  " + account + " not found.");
        }
        //接着获取对应角色
        //可优化成一次查询
        List<UserToRole> userToRoles = userToRoleMapper.selectList(new QueryWrapper<UserToRole>()
                .eq("USER_ID", user.getUserId()));
        List<Long> RoleIds = userToRoles.stream().map(UserToRole::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleMapper.selectBatchIds(RoleIds);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(roles);
        UserDetails userDetails = new User(user.getAccount(), user.getPasswords(), simpleGrantedAuthorities);
        return userDetails;
    }

    private List<SimpleGrantedAuthority> createAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }
}
