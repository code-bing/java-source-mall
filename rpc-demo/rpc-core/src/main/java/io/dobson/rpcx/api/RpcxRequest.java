package io.dobson.rpcx.api;

public class RpcxRequest {
    private String serviceClass; // 类名称
    private String method; // 方法名
    private Object[] args; // 参数

    public RpcxRequest() {
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
