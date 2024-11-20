package memoization;

import java.util.Hashtable;

public class Fibonacci {
    public static int fibonacci(int number, Hashtable<Integer, Integer> memo) {
        if (number == 0 || number == 1) return number;

        if (!memo.containsKey(number)) {
            memo.put(number, fibonacci(number - 2, memo) + fibonacci(number - 1, memo));
        }

        return memo.get(number);
    }

    public static int fibonacci2(int number) {
        if (number == 0 || number == 1) return number;

        return fibonacci2(number - 2) + fibonacci2(number - 1);
    }
}
