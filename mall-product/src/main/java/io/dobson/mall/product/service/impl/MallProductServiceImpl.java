package io.dobson.mall.product.service.impl;

import io.dobson.mall.common.DataResult;
import io.dobson.mall.product.entity.MallProduct;
import io.dobson.mall.product.service.MallProductService;

public class MallProductServiceImpl implements MallProductService {
    @Override
    public MallProduct findById(int id) {
        return MallProduct.builder().id(id).name("商品1").build();
    }

    public DataResult reduceStock(){
        return null;
    }
}
