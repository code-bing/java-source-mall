package io.dobson.rpcx.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RpcServer {
    private final ApplicationContext context;
    private EventLoopGroup boss;
    private EventLoopGroup worker;

    @Autowired
    public RpcServer(ApplicationContext context) {
        this.context = context;
    }

    public void run() throws InterruptedException {
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ServerChannelInitializer(context));
        Channel channel = bootstrap.bind(8088).sync().channel();
        log.info("server started....");
        channel.closeFuture().sync();
        log.info("server closed....");
    }

    public void shutdown() {
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
