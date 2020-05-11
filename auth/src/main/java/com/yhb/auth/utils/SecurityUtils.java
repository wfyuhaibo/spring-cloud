package com.yhb.auth.utils;

import com.yhb.auth.entity.SysUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * 安全工具类
 */
@UtilityClass
public class SecurityUtils {

	/**
	 * 获取Authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public SysUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof SysUser) {
			return (SysUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public SysUser getUser() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		return getUser(authentication);
	}

}
