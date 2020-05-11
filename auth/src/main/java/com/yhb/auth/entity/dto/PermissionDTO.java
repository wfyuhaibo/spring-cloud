package com.yhb.auth.entity.dto;

import lombok.Data;

@Data
public class PermissionDTO {

    private Long id;

    private String method;//方法类型

    private String zuulPrefix;//网关前缀

    private String servicePrefix;//服务前缀

    private String url;//请求路径

}
