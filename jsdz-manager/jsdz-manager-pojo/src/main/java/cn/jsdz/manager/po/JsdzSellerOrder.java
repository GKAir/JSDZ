package cn.jsdz.manager.po;

import java.util.Date;

public class JsdzSellerOrder {
    private String orderId;

    private String factoryId;

    private String buyerOrderId;

    private String typeId;

    private Date createTime;

    private Date updateTime;

    private String state;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId == null ? null : factoryId.trim();
    }

    public String getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(String buyerOrderId) {
        this.buyerOrderId = buyerOrderId == null ? null : buyerOrderId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}