package com.example.chapter3;

public class CapturingLamda {
    public static void main(String[] args) {
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);

        // portNumber에 값을 두 번 할당하므로 컴파일할 수 없는 코드
        Runnable r2 = () -> System.out.println(portNumber);
        //portNumber = 31337;     // 에러: 람다에서는 참고하는 지역 변수는 final로 선언되거나 실질적으로 final처럼 취급되어야 한다.
    }
}
