package com.yhb.auth.repository;

import com.yhb.auth.entity.dto.PermissionDTO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PermissionMapper {

    /**
     * 根据角色id查找权限列表
     * @param roleId 角色id
     * @return 权限列表
     */
    List<PermissionDTO> findByRoleId(Long roleId);
}
