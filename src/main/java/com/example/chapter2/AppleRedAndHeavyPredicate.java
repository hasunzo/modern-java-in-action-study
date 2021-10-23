package com.example.chapter2;

import static com.example.chapter2.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
