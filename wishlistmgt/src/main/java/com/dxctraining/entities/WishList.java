package com.dxctraining.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class WishList {
    @Id
    @Column(name = "wish_id")
    private String id;
    private Integer CustomerId;
    private String productId;

    public WishList(Integer customerId, String productId) {
        CustomerId = customerId;
        this.productId = productId;
    }
    public WishList()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return id.equals(wishList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
