package com.example.chapter3;

import com.example.apple.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class Boxing {
    public static void main(String[] args) {
        // 오토박싱
        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i);
        }

        // 오토박싱 동작을 피할 수 있도록 특별한 버전의 함수형 인터페이스 제공
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);     // 참 (박싱 없음)

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
        oddNumbers.test(1000);      // 거짓 (박싱)
    }
}
