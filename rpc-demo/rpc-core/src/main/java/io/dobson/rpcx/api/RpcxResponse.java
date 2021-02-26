package io.dobson.rpcx.api;

public class RpcxResponse {
    private Object result;
    private Boolean status;
    private Exception exception;

    public RpcxResponse() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
