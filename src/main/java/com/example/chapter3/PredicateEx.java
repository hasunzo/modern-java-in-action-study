package com.example.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {
    public static void main(String[] args) {
        List<String> listOfString = new ArrayList<>();
        listOfString.add("");
        listOfString.add("a");
        listOfString.add("b");
        listOfString.add("c");
        listOfString.add("d");
        listOfString.add("");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);

        for (String str : nonEmpty) {
            System.out.println(str);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
