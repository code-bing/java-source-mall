package io.dobson.rpcx.common;

import io.dobson.rpcx.exception.ErrorCode;
import lombok.Data;

@Data
public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;

    public CommonResult(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public CommonResult() {
        this.code = 0;
        this.msg = "success";
        this.data = null;
    }

    public CommonResult(ErrorCode errorCode) {
        if (errorCode == null) {
            return;
        }
        this.code = 500;
        this.msg = errorCode.getMsg();
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(data);
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>();
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return new CommonResult<T>(errorCode);
    }
}
