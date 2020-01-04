package com.example.luhang.orderlistlogic.bean;

/**
 * orderDetailList字段中每一项的order字段
 * GoodsOrderInfo 表示每个小订单的头部信息（订单号、订单状态、店铺名称）
 */
public class GoodsOrderInfo {

    private String orderCode;
    private String shopName;
    private String status;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
