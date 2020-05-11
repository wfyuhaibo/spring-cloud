package com.yhb.auth.service;


import com.yhb.auth.entity.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    /**
     * 根据用户id查找角色列表
     *
     * @param memberId 用户id
     * @return 角色列表
     */
    List<RoleDTO> findByMemberId(Long userID);
}
