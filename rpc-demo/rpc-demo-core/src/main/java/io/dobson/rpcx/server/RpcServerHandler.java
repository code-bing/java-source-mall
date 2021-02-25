package io.dobson.rpcx.server;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import io.dobson.rpcx.common.RpcxRequest;
import io.dobson.rpcx.common.RpcxResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.context.ApplicationContext;

public class RpcServerHandler extends SimpleChannelInboundHandler<RpcxRequest> {
    private final ApplicationContext applicationContext;

    public RpcServerHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcxRequest request) throws Exception {
        Object bean = applicationContext.getBean(request.getServiceClass());
        Method method = resolveMethodFromClass(bean.getClass(), request.getMethod());
        Object resp = method.invoke(bean, request.getArgs());
        RpcxResponse rpcxResponse = RpcxResponse.builder()
            .result(JSON.toJSONString(resp, SerializerFeature.WriteClassName))
            .status(true)
            .build();
        ctx.writeAndFlush(rpcxResponse);
    }

    private Method resolveMethodFromClass(Class<?> aClass, String method) {
        return Arrays.stream(aClass.getMethods()).filter(it -> it.getName().equals(method)).findFirst().get();
    }

}
