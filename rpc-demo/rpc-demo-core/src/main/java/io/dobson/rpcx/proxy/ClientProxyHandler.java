package io.dobson.rpcx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import io.dobson.rpcx.common.RpcxRequest;

public class ClientProxyHandler implements InvocationHandler {
    private String url;
    private String serviceClass;

    public ClientProxyHandler(String url, String serviceClass) {
        this.url = url;
        this.serviceClass = serviceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcxRequest request = RpcxRequest.builder()
            .serviceClass(this.serviceClass)
            .method(method.getName())
            .args(args)
            .build();
        //todo 使用netty 发送请求


        return null;
    }
}
