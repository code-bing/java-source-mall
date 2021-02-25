package io.dobson.rpcx.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.context.ApplicationContext;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    private ApplicationContext context;

    public ServerChannelInitializer(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new RpcServerHandler(context));
    }
}
