package io.dobson.mall.user.controller;

import io.dobson.mall.common.DataResult;
import io.dobson.mall.common.api.MallOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MallUserController {
    @DubboReference(version = "1.0.0")
    private MallOrderService mallOrderService;

    @GetMapping("/getOrderByUserId/{userId}")
    public DataResult queryOrderByUserId(@PathVariable Integer userId) {
        Assert.notNull(userId,"userId");
        return DataResult.success(mallOrderService.findByUserId(userId));
    }
}
