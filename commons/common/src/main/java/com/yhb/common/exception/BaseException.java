package com.yhb.common.exception;

/**
 * 常见异常
 */
public enum BaseException {

    //成功
    SECCESS(200, "Success"),


    //已成功处理，但是没有内容返回
    NO_CONTENT(204, "No Content"),

    //已成功处理，但是没有内容返回
    PARTIAL_CONTENT(206, "Partial Content"),

    //永久重定向
    MOVED_PERMANENTLY(301, "Moved Permanently"),

    //临时重定向
    FOUND(302, "Found"),

    //请求资源存在另一个URI，应使用GET定向获取请求资源
    SEE_OTHER(303, "See Other"),

    //客户端发送附带条件的请求（GET方法请求报文中的IF…）时，条件不满足
    NOT_MODIFIED(304, "Not Modified"),

    //临时重定向
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),

    //发送的请求需要有HTTP认证信息或者是认证失败了
    UNAUTJORIZED(401, "Unauthorized"),

    //请求资源的访问被服务器拒绝了
    FORBIDDEN(403, "Forbidden"),

    //无法找到指定位置的资源
    NOT_FOUND(404, "Not Found"),

    //请求方法（GET、POST、HEAD、DELETE、PUT、TRACE等）对指定的资源不适用
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    //指定的资源已经找到，但它的MIME类型和客户在Accpet头中所指定的不兼容
    NOT_ACCEPTABLE(406, "Not Acceptable"),

    //服务器执行请求的时候出错了
    INTENAL_SERVER_ERROR(500, "Internal Server Error"),

    //未实现
    PARAMETER_ERROR(501, "Parameter error"),

    //网关错误
    PARAMETER_IS_NULL(502, "Parameter is null"),

    //数据库错误
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    //空指针
    NULL_POINTER_EXCEPTION(10001, "NullPointerException"),

    //指定的类不存在
    CLASS_NOT_FOUND_EXCEPTION(10002, "ClassNotFoundException"),

    //数学运算异常
    ARITHMETIC_EXCEPTION(10003, "ArithmeticException"),

    //数组越界异常
    ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION(10004, "ArrayIndexOutOfBoundsException"),

    //方法参数异常
    ILLEGA_ARGUMENT_EXCEPTION(10005, "IllegalArgumentException"),

    //没有访问权限
    ILLEGA_ACCESS_EXCEPTION(10006, "IllegalAccessException"),
    //服务器内部异常
    SYSTEM_EXCEPTION(10007, "服务器内部异常"),
    //参数异常
    PARAM_EXCEPTION(10008, "参数异常"),

    //调用大华接口错误OR超时
    DAHUA_JIEKOU_EXCEPTION(10009, "调用大华接口错误OR超时"),

    //调用大华错误返回信息
    DAHUA_ERROR_EXCEPTION(10010, "调用大华错误返回信息"),

    ;

    private int code;

    private String message;

    BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String message) {
        return String.format(this.message, message == null ? "" : message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
