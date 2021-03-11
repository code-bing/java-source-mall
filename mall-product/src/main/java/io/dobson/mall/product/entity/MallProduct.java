package io.dobson.mall.product.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallProduct {
    private Integer id;
    private String name; // 商品名称
    private Integer stock; // 库存
}
