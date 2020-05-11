package com.yhb.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDTE implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField
    private Long createBy;

    @TableField
    private Date createTime;

    @TableField
    private Long updateBy;

    @TableField
    private Date updateTime;

    @TableField
    @TableLogic
    private Boolean isDeleted;

}
