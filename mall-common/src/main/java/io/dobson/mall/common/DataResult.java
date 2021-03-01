package io.dobson.mall.common;

import lombok.Data;

@Data
public class DataResult<T> {
    private T data;
    private boolean success;
    private String errorCode;
    private String message;
}
