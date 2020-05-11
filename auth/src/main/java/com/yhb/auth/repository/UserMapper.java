package com.yhb.auth.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhb.auth.entity.dte.UserDTE;
import com.yhb.auth.entity.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserDTE> {

    /**
     * 根据会员名查找会员
     * @param name 会员名
     * @return 会员
     */
    UserDTO findByName(String name);
}
