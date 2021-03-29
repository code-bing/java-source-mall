package io.dobson.mall.user;

import java.util.List;

import io.dobson.mall.common.api.MallOrder;
import io.dobson.mall.common.api.MallOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MallUserApplication {
    @DubboReference(version = "1.0.0")
    private MallOrderService mallOrderService;

    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            List<MallOrder> mallOrders = mallOrderService.findByUserId(1111);
            System.out.println(mallOrders);
        };
    }
}
