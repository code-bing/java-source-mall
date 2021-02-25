package io.dobson.rpcx.server;

import com.alibaba.fastjson.JSON;

import io.dobson.rpcx.common.RpcxResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ResponseEncoder extends MessageToByteEncoder<RpcxResponse> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RpcxResponse msg, ByteBuf out) throws Exception {
        out.writeBytes(JSON.toJSONBytes(msg));
    }
}
