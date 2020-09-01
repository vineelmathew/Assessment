package com.dxctraining.dto;

public class CreateSupplier {
    private String name;

    public CreateSupplier(String name) {
        this.name = name;
    }

    public CreateSupplier()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
