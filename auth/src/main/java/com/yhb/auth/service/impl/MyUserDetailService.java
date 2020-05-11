package com.yhb.auth.service.impl;

import com.yhb.auth.entity.dto.PermissionDTO;
import com.yhb.auth.entity.dto.RoleDTO;
import com.yhb.auth.entity.dto.UserDTO;
import com.yhb.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("userDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findByName(memberName);
        if (userDTO == null) {
            throw new UsernameNotFoundException(memberName+" 用户不存在");
        }
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (RoleDTO roleDTO : userDTO.getRoles()) {
            //角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleDTO.getName());
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            for (PermissionDTO permission : roleDTO.getPermissions()) {
                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getUrl());
                grantedAuthorities.add(authority);
            }
        }

        User user = new User(userDTO.getName(), userDTO.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }

}
