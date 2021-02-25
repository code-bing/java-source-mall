package io.dobson.rpcx.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RpcxRequest {
    private String serviceClass; // 类名称
    private String method; // 方法名
    private Object[] args; // 参数
}
