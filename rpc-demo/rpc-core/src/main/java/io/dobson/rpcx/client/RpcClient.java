package io.dobson.rpcx.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.alibaba.fastjson.JSON;

import io.dobson.rpcx.api.RpcxRequest;
import io.dobson.rpcx.api.RpcxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcClient {

    private enum Singleton {
        INSTANCE;

        private final RpcClient rpcNettyClient;

        Singleton() {
            this.rpcNettyClient = new RpcClient();
        }

        public RpcClient getInstance() {
            return rpcNettyClient;
        }

    }

    public static RpcClient getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private RpcClient() {}

    private final EventLoopGroup worker = new NioEventLoopGroup();
    private final ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();

    public RpcxResponse sendRequest(RpcxRequest request, String url) throws URISyntaxException, InterruptedException {
        URI uri = new URI(url);
        Channel channel;
        if (channelMap.containsKey(url)) {
            channel = channelMap.get(url);
            if (!channel.isOpen() || !channel.isActive() || !channel.isWritable()) {
                log.error("channel 不可用");
            } else {
                try {
                    channel.writeAndFlush(JSON.toJSONString(request).getBytes(CharsetUtil.UTF_8)).sync();
                    RpcClientHandler handler = (RpcClientHandler)channel.pipeline().get("clientHandler");
                    return handler.getRpcxResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                    channel.close();
                    channelMap.remove(url);
                }

            }
        }

        channel = this.createChannel(uri.getHost(), uri.getPort());
        channelMap.put(url, channel);
        byte[] bytes = JSON.toJSONString(request).getBytes(CharsetUtil.UTF_8);
        channel.writeAndFlush(Unpooled.copiedBuffer(bytes)).sync();
        RpcClientHandler handler = (RpcClientHandler)channel.pipeline().get("clientHandler");
        return handler.getRpcxResponse();
    }

    public Channel createChannel(String host, int port) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("clientHandler", new RpcClientHandler(new CountDownLatch(1)));
                }
            });
        return bootstrap.connect(host, port).sync().channel();
    }
}
