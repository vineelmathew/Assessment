package com.dxctraining.dto;

public class CreateProduct {
    private String name;

    public CreateProduct(String name) {
        this.name = name;
    }
    public CreateProduct()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
