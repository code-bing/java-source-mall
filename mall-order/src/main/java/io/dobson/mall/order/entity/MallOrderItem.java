package io.dobson.mall.order.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallOrderItem {
    private Integer id;
    private Integer userId;
    private Long orderId;
    private Integer productId;
    private String productName;
}
