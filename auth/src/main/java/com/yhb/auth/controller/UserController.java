package com.yhb.auth.controller;

import com.yhb.auth.entity.SysUser;
import com.yhb.auth.entity.dte.UserDTE;
import com.yhb.auth.entity.dto.UserDTO;
import com.yhb.auth.service.UserService;
import com.yhb.auth.service.impl.MyUserDetailService;
import com.yhb.auth.utils.SecurityUtils;
import com.yhb.common.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/api/user")
@Api(tags = "auth相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("")
    public Principal user(Principal user) {
        return user;
    }

    /**
     * 获取当前用户全部信息
     *
     * @return 用户信息
     */
    @GetMapping(value = {"/info"})
    public Result info() {
        Long userId = SecurityUtils.getUser().getId();
        return Result.success(userService.findById(userId));
    }

    /**
     * 获取指定用户全部信息
     *
     * @return 用户信息
     */
    @GetMapping("/info/{username}")
    public Result info(@PathVariable String username) {
        return Result.success(userService.findByName(username));
    }

    /**
     * 通过ID查询用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result user(@PathVariable Long id) {
        return Result.success(userService.findById(id));
    }



    /*@DeleteMapping(value = "/exit")
    public ResponseEntity revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return ResponseEntity.success();
        }
        return ResponseEntity.fail(ResultCode.EXITFAILED.getCode(),"操作失败");
    }*/

}
