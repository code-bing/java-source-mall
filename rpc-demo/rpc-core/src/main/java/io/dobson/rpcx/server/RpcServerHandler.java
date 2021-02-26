package io.dobson.rpcx.server;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import io.dobson.rpcx.api.RpcxRequest;
import io.dobson.rpcx.api.RpcxResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcxRequest> {
    private final ApplicationContext applicationContext;

    public RpcServerHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("a client connected");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcxRequest request) throws Exception {
        log.info("received msg");
        Object bean = applicationContext.getBean(request.getServiceClass());
        Method method = resolveMethodFromClass(bean.getClass(), request.getMethod());
        Object resp = method.invoke(bean, request.getArgs());
        RpcxResponse rpcxResponse = new RpcxResponse();
        rpcxResponse.setResult(JSON.toJSONString(resp, SerializerFeature.WriteClassName));
        rpcxResponse.setStatus(true);
        ctx.writeAndFlush(rpcxResponse);
    }

    private Method resolveMethodFromClass(Class<?> aClass, String method) {
        return Arrays.stream(aClass.getMethods()).filter(it -> it.getName().equals(method)).findFirst().get();
    }

}
