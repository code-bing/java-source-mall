package io.dobson.mall.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallProduct {
    private Integer id;
    private String name;
}
