package com.dxctraining.exceptions;

public class WishListNotFoundException extends RuntimeException {
    public WishListNotFoundException(String msg)
    {
        super(msg);
    }
}
