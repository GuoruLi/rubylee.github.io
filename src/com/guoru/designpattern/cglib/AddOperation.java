package com.cglib;

public class AddOperation implements IOperation{
    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}