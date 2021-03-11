package io.dobson.mall.order.service.impl;

import java.util.List;

import com.google.common.collect.Lists;
import io.dobson.mall.order.entity.MallOrder;
import io.dobson.mall.order.service.MallOrderService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class MallOrderServiceImpl implements MallOrderService {

    @Override
    public List<MallOrder> findByUserId(int id) {
        return Lists.newArrayList(MallOrder.builder()
            .id(1234)
            .userId(1222222)
            .orderNo(24234234L).build());
    }
}
