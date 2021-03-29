package io.dobson.mall.user.service;

import io.dobson.mall.common.DataResult;

public interface UserService {
    DataResult getOrderByUserId(Integer userId);

}
