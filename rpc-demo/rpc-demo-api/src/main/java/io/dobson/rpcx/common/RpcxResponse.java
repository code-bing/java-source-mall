package io.dobson.rpcx.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RpcxResponse {
    private Object result;
    private Boolean status;
    private Exception exception;
}
