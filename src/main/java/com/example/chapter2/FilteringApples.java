package com.example.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.chapter2.Color.GREEN;
import static com.example.chapter2.Color.RED;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, GREEN),
                                            new Apple(155, GREEN),
                                            new Apple(120, RED));
        List<Apple> heavyApples =
                filterApples(inventory, new AppleHeavyWeightPredicate()); // 155그램의 사과 한 개를 포함한다.
        List<Apple> greenApples =
                filterApples(inventory, new AppleGreenColorPredicate());  // 녹색 사과 두 개를 포함한다.

        // 다섯 번째 시도
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        // 여섯 번째 시도 : 드디어 람다
        List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        // 일곱 번째 시도 : 리스트 형식으로 추상화
        List<Apple> redApples2 =
                filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers =
                filter(numbers, (Integer i) -> i % 2 == 0);

    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
