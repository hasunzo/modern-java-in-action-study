package com.example.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class Process {
    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        // 예외를 던지는 람다 표현식 만들기 - try/catch 블록으로
        Function<BufferedReader, String> f = (BufferedReader b) -> {
            try {
                return b.readLine();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);   // 실제 작업을 하는 행
        }
    }
}
