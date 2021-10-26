package com.example.apple;

import static com.example.apple.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
