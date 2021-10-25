package com.example.chapter2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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

        System.out.println(numbers);
        System.out.println(numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList()));

        int[] numArr = {1, 2, 4, 5, 7, 8, 10, 12, 14, 16,300, 18, 20};

        List<Integer> list = Arrays.stream(numArr).parallel().filter(num -> num % 2 == 0).boxed().collect(Collectors.toList());

        // 문자열로 변환
        List<String> list2 = Arrays.stream(numArr).filter(num -> num % 2 == 0).mapToObj(String::valueOf).collect(Collectors.toList());

        // 최대값 뽑기
        int max = Arrays.stream(numArr).max().orElse(-1);

        // Comparator로 정렬하기
        // 사과의 무게가 적은 순서로
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        // 람다 표현식으로
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // Runnable로 코드 블록 실행하기
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello world"));

        // GUI 이벤트 처리하기
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());

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
