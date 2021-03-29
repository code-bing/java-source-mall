package io.dobson.mall.user.service.impl;

import io.dobson.mall.common.DataResult;
import io.dobson.mall.common.api.MallOrderService;
import io.dobson.mall.user.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Reference(version = "1.0.0")
    private MallOrderService orderService;

    @Override
    public DataResult getOrderByUserId(Integer userId) {
        return DataResult.success(orderService.findByUserId(userId));
    }
}
