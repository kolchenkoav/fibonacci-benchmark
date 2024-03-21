package fibonacci;

import java.util.stream.Stream;

public class Fibonacci {
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static long fibonacciRecursive(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static long fibonacciStream(long n) {
        return Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
            .limit(n)
            .mapToLong(fib -> fib[0])
            .reduce((first, second) -> second)
            .orElse(0);
    }

    public static long fibonacciParallelStream(long n) {
        return Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
            .parallel()
            .limit(n)
            .mapToLong(fib -> fib[0])
            .reduce((first, second) -> second)
            .orElse(0);
    }
}
