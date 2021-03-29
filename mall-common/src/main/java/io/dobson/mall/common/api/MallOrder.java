package io.dobson.mall.common.api;


import java.io.Serializable;

public class MallOrder implements Serializable {
    private Integer id;
    private Integer userId;
    private Long orderNo;

    public MallOrder(Integer id, Integer userId, Long orderNo) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "MallOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNo=" + orderNo +
                '}';
    }
}
