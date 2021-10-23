package com.example.chapter2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.example.chapter2.Color.GREEN;
import static com.example.chapter2.Color.RED;

@Getter
public class Apple {
    private Color color;
    private int weight;

    public Apple(Color color, int wight) {
        this.color = color;
        this.weight = wight;
    }

    // 네번째 시도 : 추상적 조건으로 필터링
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {    // 프레디케이트 객체로 사과 검사 조건을 캡슐화했다.
                result.add(apple);
            }
        }
        return result;
    }

    // 2-1 퀴즈 : 유연한 prettyPrintApple 메서드 구현하기
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    /*
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();     // 사과 누적 리스트
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {   // 녹색 사과만 선택
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(GREEN, 150));
        inventory.add(new Apple(RED, 150));
        inventory.add(new Apple(RED, 100));
        inventory.add(new Apple(GREEN, 100));

        //List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
        //List<Apple> redApples = filterApplesByColor(inventory, RED);

        // 세번째 시도
        /*List<Apple> greenApples = filterApples(inventory, GREEN, 0, true);
        List<Apple> heavyApples = filterApples(inventory, null, 150, false);*/

        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
