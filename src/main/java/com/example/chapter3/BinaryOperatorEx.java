package com.example.chapter3;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorEx {
    public static void main(String[] args) {
        IntBinaryOperator ibo = (int a, int b) -> Math.max(a, b);
        binary(1, 2, ibo);
    }

    public static <T> void binary(int a, int b, IntBinaryOperator i) {
        System.out.println(i.applyAsInt(a, b));
    }
}
