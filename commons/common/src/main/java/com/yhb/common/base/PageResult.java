package com.yhb.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    @ApiModelProperty("总数量")
    private Long totalElements;
    @ApiModelProperty("总页数")
    private Integer totalPages;
    @ApiModelProperty("内容")
    private List<T> content;
}
