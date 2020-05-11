package com.yhb.auth.entity.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String password;

    private String email;

    private Integer sex;

    private String mobile;

    private Date birthday;

    private Set<RoleDTO> roles;

}
