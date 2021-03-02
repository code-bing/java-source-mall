package io.dobson.rpcx.exception;

public enum ErrorCode {
    SERVER_ERROR("SERVER_ERROR", "服务错误"),
    INSERT_ERROR("INSERT_ERROR", "插入错误"),
    INVOKE_ERROR("INVOKE_ERROR", "调用失败"),
    ;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private String code;
    private String msg;

}
