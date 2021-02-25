package io.dobson.mall.service.impl;

import io.dobson.mall.entity.MallProduct;
import io.dobson.mall.service.MallProductService;

public class MallProductServiceImpl implements MallProductService {
    @Override
    public MallProduct findById(int id) {
        return MallProduct.builder().id(id).name("商品1").build();
    }
}
