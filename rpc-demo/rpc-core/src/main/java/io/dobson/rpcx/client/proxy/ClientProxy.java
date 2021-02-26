package io.dobson.rpcx.client.proxy;

import java.lang.reflect.Proxy;

public class ClientProxy {

    public static  <T> T  createProxy(Class<T> tClass, String url){

        return (T)Proxy.newProxyInstance(ClientProxy.class.getClassLoader(), new Class[]{tClass}, new ClientProxyHandler(url,tClass.getName()));
    }
}
