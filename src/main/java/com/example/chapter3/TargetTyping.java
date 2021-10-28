package com.example.chapter3;

import com.example.apple.Apple;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public class TargetTyping {
    public static void main(String[] args) {
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> pa = () -> 42;

        // 하나의 람다 표현식을 다양한 함수형 인터페이스에서 사용하기
        Comparator<Apple> c1 =
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 =
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 =
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // 다이아몬드 연산자
        List<String> listOfStrings = new ArrayList<>();
        List<Integer> listOfIntegers = new ArrayList<>();

        List<String> list = new ArrayList<>();

        // 특별한 void 호환 규칙
        // Predicate는 불리언 반환값을 갖는다.
        Predicate<String> p = s -> list.add(s);
        // Consumer는 void 반환값을 갖는다.
        Consumer<String> b = s -> list.add(s);
    }
}
