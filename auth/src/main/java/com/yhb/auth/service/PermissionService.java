package com.yhb.auth.service;


import com.yhb.auth.entity.dto.PermissionDTO;
import java.util.List;

public interface PermissionService {

    /**
     * 根据角色id查找权限列表
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    List<PermissionDTO> findByRoleId(Long roleId);

}
