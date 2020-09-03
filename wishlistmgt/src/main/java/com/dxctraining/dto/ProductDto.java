package com.dxctraining.dto;

public class ProductDto {
    private String name;
    private String id;

    public ProductDto(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public ProductDto()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
