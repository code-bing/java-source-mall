package io.dobson.mall.common;

import lombok.Data;

@Data
public class DataResult<T> {
    private T data;
    private boolean success;
    private String errorCode;
    private String message;

    public DataResult(T data) {
        this.success = true;
        this.data = data;
    }

    public DataResult() {
        this.success = true;
        this.message = "success";
        this.data = null;
    }


    public static <T> DataResult<T> success(T data) {
        return new DataResult<T>(data);
    }

    public static <T> DataResult<T> success() {
        return new DataResult<T>();
    }

}
