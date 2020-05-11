package com.yhb.auth.service.impl;

import com.yhb.auth.entity.dto.PermissionDTO;
import com.yhb.auth.repository.PermissionMapper;
import com.yhb.auth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据角色id查找权限列表
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    public List<PermissionDTO> findByRoleId(Long roleId) {
        List<PermissionDTO> list = new ArrayList<PermissionDTO>();//permissionRepository.findAll();
        PermissionDTO newPermissionDTO1 = new PermissionDTO();
        newPermissionDTO1.setId(1L);
        newPermissionDTO1.setMethod("GET");
        newPermissionDTO1.setServicePrefix("/auth");
        newPermissionDTO1.setZuulPrefix("/api");
        newPermissionDTO1.setUrl("exit");

        PermissionDTO newPermissionDTO2 = new PermissionDTO();
        newPermissionDTO2.setId(1L);
        newPermissionDTO2.setMethod("GET");
        newPermissionDTO2.setServicePrefix("/auth");
        newPermissionDTO2.setZuulPrefix("/api");
        newPermissionDTO2.setUrl("user");

        list.add(newPermissionDTO1);
        list.add(newPermissionDTO2);
        return list;
    }

}
