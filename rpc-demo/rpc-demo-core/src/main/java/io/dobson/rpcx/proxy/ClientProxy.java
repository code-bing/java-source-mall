package io.dobson.rpcx.proxy;

import java.lang.reflect.Proxy;

public class ClientProxy {

    public <T>Object createProxy(Class<T> tClass, String url){

        return Proxy.newProxyInstance(tClass.getClassLoader(), tClass.getInterfaces(), new ClientProxyHandler(url,tClass.getName()));
    }
}
