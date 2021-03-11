package io.dobson.mall.order.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallOrder {
    private Integer id;
    private Integer userId;
    private Long orderNo;

}
