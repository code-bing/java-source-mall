package io.dobson.mall.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallUser {
    private Integer id;
    private String username;
}
