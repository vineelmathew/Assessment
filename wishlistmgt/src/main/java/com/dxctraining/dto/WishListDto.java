package com.dxctraining.dto;

public class WishListDto {
    private String id;
    private String productId;
    private Integer customerId;
    private String customerName;
    private String productName;

    public WishListDto(String id, String productId, Integer customerId) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
    }
    public WishListDto()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
