package com.yhb.account.dte;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;

    private String userId;

    private Integer money;

}
