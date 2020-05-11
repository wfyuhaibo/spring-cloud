package com.yhb.auth.repository;

import com.yhb.auth.entity.dto.RoleDTO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleMapper {

    /**
     * 根据用户id查找角色列表
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleDTO> findByUserId(Long userId);
}
