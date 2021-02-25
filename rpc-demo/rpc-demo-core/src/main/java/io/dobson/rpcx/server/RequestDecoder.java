package io.dobson.rpcx.server;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class RequestDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes()>0){
            byte [] bytes = new byte[in.readableBytes()];
            in.writeBytes(bytes);
            out.add(bytes);
        }
    }
}
