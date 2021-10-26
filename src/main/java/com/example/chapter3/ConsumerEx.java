package com.example.chapter3;

import com.example.apple.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.example.apple.Color.GREEN;
import static com.example.apple.Color.RED;

public class ConsumerEx {
    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5),
                (Integer i) -> System.out.println(i)
        );  // Consumer의 accept 메서드를 구현하는 람다

        forEach(Arrays.asList(new Apple(10, RED), new Apple(20, GREEN)),
                (Apple a) -> System.out.println("사과의 색상은: "+a.getColor()+" 사과의 무게는: "+a.getWeight()));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
