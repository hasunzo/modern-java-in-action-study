package com.example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionEx {
    public static  <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;


    }

    public static void main(String[] args) {
        // [7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lamdas", "in", "action"),
                (String s) -> s.length()
        );  // Function의 apply 메서드를 구현하는 람다
    }
}
