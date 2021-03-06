package io.dobson.rpcx.client.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import io.dobson.rpcx.api.RpcxResponse;
import io.dobson.rpcx.client.RpcClient;
import io.dobson.rpcx.api.RpcxRequest;
import io.dobson.rpcx.exception.ErrorCode;
import io.dobson.rpcx.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientProxyHandler implements InvocationHandler {
    private String url;
    private String serviceClass;

    static {
        ParserConfig.getGlobalInstance().addAccept("io.dobson");

    }

    public ClientProxyHandler(String url, String serviceClass) {
        this.url = url;
        this.serviceClass = serviceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws URISyntaxException, InterruptedException {
        RpcxRequest request = new RpcxRequest();
        request.setServiceClass(this.serviceClass);
        request.setMethod(method.getName());
        request.setArgs(args);
        RpcClient nettyClient = RpcClient.getInstance();
        String resp = (String) nettyClient.sendRequest(request, this.url).getResult();
        return JSON.parse(resp);
    }
}
