package io.dobson.mall.service;

import java.util.List;

import io.dobson.mall.entity.MallOrder;

public interface MallOrderService {
    List<MallOrder> findByUserId(int id);
}
