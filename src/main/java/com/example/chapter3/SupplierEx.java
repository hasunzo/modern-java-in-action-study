package com.example.chapter3;

import com.example.apple.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static com.example.apple.Color.RED;

public class SupplierEx {
    public static void main(String[] args) {
        supplier(() -> "hello");

        IntSupplier num = () -> (int) ((Math.random() * 6) +1);
        System.out.println(num.getAsInt());

        supplier(() -> new Apple(10, RED));

        List<Apple> apples = suppliarToApple(5, () -> new Apple(10, RED));

        for (Apple apple : apples) {
            System.out.println("사과 무게: "+apple.getWeight()+" 사과 색깔: "+apple.getColor());
        }
    }
    public static <T> void supplier(Supplier<T> s) {
        System.out.println(s.get());
    }

    public static <T> List<Apple> suppliarToApple(int number, Supplier<T> s) {
        List<Apple> result = new ArrayList<Apple>();

        for (int i = 0; i < number; i++) {
            result.add((Apple) s.get());
        }

        return result;
    }
}
