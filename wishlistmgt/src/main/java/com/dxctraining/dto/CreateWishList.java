package com.dxctraining.dto;

public class CreateWishList {
         private Integer customerId;
         private String productId;

    public CreateWishList(Integer customerId, String productId) {
        this.customerId = customerId;
        this.productId = productId;
    }
    public CreateWishList()
    {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
