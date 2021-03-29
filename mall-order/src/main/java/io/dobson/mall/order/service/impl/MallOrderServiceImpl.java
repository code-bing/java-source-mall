package io.dobson.mall.order.service.impl;

import com.google.common.collect.Lists;
import io.dobson.mall.order.entity.MallOrder;
import io.dobson.mall.order.service.MallOrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

@DubboService(version = "1.0.0")
@Service
public class MallOrderServiceImpl implements MallOrderService {

    @Override
    public List<MallOrder> findByUserId(int id) {

        return Lists.newArrayList(new MallOrder(1234, 23455668, 2423232343L));
    }
}
