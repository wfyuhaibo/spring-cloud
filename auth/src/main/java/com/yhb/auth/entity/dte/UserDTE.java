/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.yhb.auth.entity.dte;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yhb.common.entity.BaseDTE;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;


/**
 * 系统用户
 */
@Data
@TableName("t_user")
public class UserDTE extends BaseDTE {

	/**
	 * 用户ID
	 *
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户名
	 */
	@NotBlank(message="用户名不能为空")
	@Size(min = 2,max = 20,message = "用户名长度要在2-20之间")
	private String name;

	/**
	 * 密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	@Pattern(regexp="0?1[0-9]{10}",message = "请输入正确的手机号")
	private String mobile;

	private Integer sex;

	private Date birthday;

	/**
	 * 部门ID
	 */
	private Integer deptId;


}
