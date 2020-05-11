package com.yhb.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhb.auth.entity.dte.UserDTE;
import com.yhb.auth.entity.dto.UserDTO;

public interface UserService extends IService<UserDTE> {

    /**
     * 根据会员名查找会员
     *
     * @param name 会员名
     * @return 会员
     */
    UserDTO findByName(String name);

    /**
     * 根据会员名查找会员
     *
     * @param id 会员id
     * @return 会员
     */
    UserDTO findById(Long id);

}
