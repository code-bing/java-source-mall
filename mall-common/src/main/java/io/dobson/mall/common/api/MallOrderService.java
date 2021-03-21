package io.dobson.mall.common.api;

import java.util.List;

public interface MallOrderService {
    List<MallOrder> findByUserId(int id);
}
