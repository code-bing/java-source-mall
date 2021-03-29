package io.dobson.mall.user;

import io.dobson.mall.order.entity.MallOrder;
import io.dobson.mall.order.service.MallOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class MallUserApplication {
    @DubboReference(version = "1.0.0")
    MallOrderService mallOrderService;

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
