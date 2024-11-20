package memoization;

import java.util.Hashtable;

public class FibonacciTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int fibonacci = Fibonacci.fibonacci(44, new Hashtable<>());
        System.out.println("fibonacci = " + fibonacci);

        long end = System.currentTimeMillis();

        System.out.println("fibonacci time = " + (end - start) + "ms");

        start = System.currentTimeMillis();
        int fibonacci2 = Fibonacci.fibonacci2(44);
        System.out.println("fibonacci2 = " + fibonacci2);
        end = System.currentTimeMillis();

        System.out.println("fibonacci2 time = " + (end - start) + "ms");
    }
}
