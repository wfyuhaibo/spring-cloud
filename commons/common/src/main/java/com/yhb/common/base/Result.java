package com.yhb.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel
public class Result<T> implements Serializable {

    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 400;
    public static final int DEFUALT_EXCEPTION_CODE = 700;
    public static final String DEFUALT_RESULT_TPYE = "default";
    public static final int UN_LOGIN_CODE = 999;
    public static final int DUPLICATION_OF_NAME =10001;//重名
    public static final int OTHER_EXCEPTION = 10002;//未知异常

    public static final String DEFAULT_SUCC_MSG = "ok";
    public static final String DEFAULT_FAIL_MSG = "fail";

    public static Result<Object> SUCCESS = new Result<>(SUCCESS_CODE, null);
    public static Result<Object> FAIL = new Result<>(FAIL_CODE, null);

    /**
     * 响应编码
     **/
    @ApiModelProperty(value = "响应编码")
    private int code;
    /**
     * 响应提示语
     **/
    @ApiModelProperty(value = "响应提示语")
    private String msg;
    /**
     * 响应对象
     **/
    @ApiModelProperty(value = "响应对象")
    private T data;

    public Result() {
        this.code = SUCCESS_CODE;
        this.msg = DEFAULT_SUCC_MSG;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    public static Result fail(int code, String msg) {
        return new Result(code, msg);
    }


    public static Result success() {
        return new Result();
    }

    public static <T> Result success(T data) {
        return new Result(data);
    }

}
