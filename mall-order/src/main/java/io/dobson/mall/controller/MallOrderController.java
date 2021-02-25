package io.dobson.mall.controller;

import java.util.List;

import io.dobson.mall.entity.MallOrder;
import io.dobson.mall.service.MallOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MallOrderController {
    private final MallOrderService mallOrderService;

    @Autowired
    public MallOrderController(MallOrderService mallOrderService) {
        this.mallOrderService = mallOrderService;
    }

    @ApiOperation("通过用户ID查询订单列表")
    public List<MallOrder> queryByUserId(int userId) {
        return mallOrderService.findByUserId(userId);
    }
}
