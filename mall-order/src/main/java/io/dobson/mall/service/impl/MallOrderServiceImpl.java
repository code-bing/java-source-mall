package io.dobson.mall.service.impl;

import java.util.List;

import com.google.common.collect.Lists;
import io.dobson.mall.entity.MallOrder;
import io.dobson.mall.service.MallOrderService;
import org.springframework.stereotype.Service;

@Service
public class MallOrderServiceImpl implements MallOrderService {

    @Override
    public List<MallOrder> findByUserId(int id) {
        return Lists.newArrayList(MallOrder.builder()
            .id(1234)
            .userId(1222222)
            .orderNo(24234234L).build());
    }
}
