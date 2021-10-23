package com.example.chapter2;

import static com.example.chapter2.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
