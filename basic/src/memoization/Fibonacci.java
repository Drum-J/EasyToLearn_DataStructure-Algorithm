package memoization;

import java.util.Hashtable;

public class Fibonacci {

    //하향식 계산 방법 - 메모이제이션
    public static int fibonacci(int number, Hashtable<Integer, Integer> memo) {
        if (number == 0 || number == 1) return number;

        if (!memo.containsKey(number)) {
            memo.put(number, fibonacci(number - 2, memo) + fibonacci(number - 1, memo));
        }

        return memo.get(number);
    }

    // 단순 재귀
    public static int fibonacci2(int number) {
        if (number == 0 || number == 1) return number;

        return fibonacci2(number - 2) + fibonacci2(number - 1);
    }

    // 상향식 계산 방법 - 타뷸레이션
    public static int fibonacci3(int number) {
        if (number <= 1) return number;

        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(0, 0);
        table.put(1, 1);
        for (int i = 2; i <= number; i++) {
            table.put(i, table.get(i - 2) + table.get(i - 1));
        }

        return table.get(number);
    }
}
