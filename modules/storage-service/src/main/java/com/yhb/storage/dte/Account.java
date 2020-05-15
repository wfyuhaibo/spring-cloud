package com.yhb.storage.dte;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;

    private String userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;
}
