package io.dobson.rpcx.api;

import java.util.List;

import com.alibaba.fastjson.JSON;

import io.dobson.rpcx.api.RpcxRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("transport byte length: " + in.readableBytes());
        if (in.readableBytes() > 0) {
            byte[] bytes = new byte[in.readableBytes()];
            in.readBytes(bytes);
            RpcxRequest rpcxRequest = JSON.parseObject(new String(bytes, CharsetUtil.UTF_8), RpcxRequest.class);
            out.add(rpcxRequest);
        }
    }
}
