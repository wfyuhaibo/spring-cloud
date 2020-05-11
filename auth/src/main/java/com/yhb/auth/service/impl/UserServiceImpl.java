package com.yhb.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhb.auth.entity.dte.UserDTE;
import com.yhb.auth.entity.dto.PermissionDTO;
import com.yhb.auth.entity.dto.RoleDTO;
import com.yhb.auth.entity.dto.UserDTO;
import com.yhb.auth.repository.PermissionMapper;
import com.yhb.auth.repository.RoleMapper;
import com.yhb.auth.repository.UserMapper;
import com.yhb.auth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDTE> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDTO findByName(String name) {
        UserDTO userDTO = userMapper.findByName(name);
        if (ObjectUtils.isEmpty(userDTO)) {
            return null;
        }

        //获取用户角色
        userDTO = getUserInfo(userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findById(Long id) {
        UserDTE userDTE = userMapper.selectById(id);
        if (ObjectUtils.isEmpty(userDTE)) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDTE, userDTO);
        //获取用户角色
        userDTO = getUserInfo(userDTO);
        return userDTO;
    }

    public UserDTO getUserInfo(UserDTO userDTO) {

        List<RoleDTO> roleList = roleMapper.findByUserId(userDTO.getId());
        if (!CollectionUtils.isEmpty(roleList)) {
            Set<RoleDTO> roles = new HashSet<>();
            for (RoleDTO roleDTO : roleList) {
                //获取角色对应的权限
                List<PermissionDTO> permissionList = permissionMapper.findByRoleId(roleDTO.getId());
                Set<PermissionDTO> permissions = new HashSet<>();
                permissions.addAll(copyTo(permissionList, PermissionDTO.class));
                roleDTO.setPermissions(permissions);
                roles.add(roleDTO);
            }
            userDTO.setRoles(roles);
        }
        return userDTO;
    }

    public static <E> List<E> copyTo(List<?> source, Class<E> destinationClass) {
        if (source.size() == 0) return Collections.emptyList();
        List<E> res = new ArrayList<>(source.size());
        try {
            for (Object o : source) {
                E e = destinationClass.newInstance();
                BeanUtils.copyProperties(o, e, destinationClass);
                res.add(e);
            }
        } catch (Exception e) {

        }
        return res;
    }


}
