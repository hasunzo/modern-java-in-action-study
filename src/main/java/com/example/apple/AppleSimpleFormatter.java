package com.example.apple;

public class AppleSimpleFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        return "An apple of "+apple.getWeight()+"g";
    }
}
