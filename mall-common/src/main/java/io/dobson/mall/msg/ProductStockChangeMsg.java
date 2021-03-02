package io.dobson.mall.msg;

import lombok.Data;

@Data
public class ProductStockChangeMsg {
    private String productId; // 商品Id
    private Integer num; // 数量
    private String operation; // 操作
}
