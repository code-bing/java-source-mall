package io.dobson.rpcx.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RpcNettyServer {
    private final ApplicationContext context;

    public RpcNettyServer(ApplicationContext context) {
        this.context = context;
    }

    public void run(){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,worker)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ServerChannelInitializer(context));
    }
}
