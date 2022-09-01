package com.smart.web.common.result;

import lombok.Data;

/**
 * 封装统一结果集
 */
@Data
public class ResponseResult<T> {
    private String msg;
    private int status;
    private T data;

    public static <T> ResponseResult<T> success(ResponseCode responseCode, T data) {
        return ResponseResult.common(responseCode, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return common(ResponseCode.SUCCESS, data);
    }

    public static <T> ResponseResult<T> error() {
        return ResponseResult.common(ResponseCode.SYS_Error, null);
    }

    public static <T> ResponseResult<T> error(ResponseCode responseCode) {
        return common(responseCode, null);
    }

    public static <T> ResponseResult<T> error(ResponseCode responseCode, T data) {
        return common(responseCode, data);
    }

    private static <T> ResponseResult<T> common(ResponseCode responseCode, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setMsg(responseCode.getMsg());
        result.setStatus(responseCode.getStatus());
        result.setData(data);
        return result;
    }
}
