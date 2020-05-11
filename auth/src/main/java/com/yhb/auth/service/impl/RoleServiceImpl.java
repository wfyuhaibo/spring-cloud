package com.yhb.auth.service.impl;

import com.yhb.auth.entity.dto.PermissionDTO;
import com.yhb.auth.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements PermissionService {

    @Override
    public List<PermissionDTO> findByRoleId(Long roleId) {
        List<PermissionDTO> list = new ArrayList<PermissionDTO>();//permissionRepository.findAll();
        PermissionDTO newPermissionDTO1 = new PermissionDTO();
        newPermissionDTO1.setId(1L);
        newPermissionDTO1.setMethod("GET");
        newPermissionDTO1.setServicePrefix("/auth");
        newPermissionDTO1.setZuulPrefix("/api");
        newPermissionDTO1.setUrl("exit");
        list.add(newPermissionDTO1);
        return list;
    }
}
