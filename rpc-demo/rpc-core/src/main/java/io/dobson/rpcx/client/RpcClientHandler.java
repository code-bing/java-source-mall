package io.dobson.rpcx.client;

import java.util.concurrent.CountDownLatch;

import com.alibaba.fastjson.JSON;

import io.dobson.rpcx.api.RpcxResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcClientHandler extends SimpleChannelInboundHandler<Object> {
    private RpcxResponse rpcxResponse;
    private CountDownLatch latch;

    RpcClientHandler(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("received msg from server");
        ByteBuf byteBuf = (ByteBuf)msg;
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        this.rpcxResponse = JSON.parseObject(new String(bytes, CharsetUtil.UTF_8), RpcxResponse.class);
        latch.countDown();
    }

    public RpcxResponse getRpcxResponse() throws InterruptedException {
        // 等请求成功之后再返回
        latch.await();
        return rpcxResponse;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
