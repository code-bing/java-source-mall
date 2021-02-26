package io.dobson.rpcx.api;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class ResponseEncoder extends MessageToByteEncoder<RpcxResponse> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RpcxResponse msg, ByteBuf out) throws Exception {
        out.writeBytes(JSON.toJSONString(msg).getBytes(CharsetUtil.UTF_8));
    }
}
