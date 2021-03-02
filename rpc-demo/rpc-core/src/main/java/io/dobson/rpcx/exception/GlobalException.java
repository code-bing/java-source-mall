package io.dobson.rpcx.exception;

public class GlobalException extends RuntimeException {
    private ErrorCode errorCode;

    public GlobalException(ErrorCode errorCode) {
        super(errorCode.toString());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
