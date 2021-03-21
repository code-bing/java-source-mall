package io.dobson.mall.order.service;

import java.util.List;

import io.dobson.mall.order.entity.MallOrder;

public interface MallOrderService {
    List<MallOrder> findByUserId(int id);
}
