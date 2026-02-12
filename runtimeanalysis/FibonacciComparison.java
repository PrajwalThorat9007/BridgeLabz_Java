package runtimeanalysis;

public class FibonacciComparison {
    // Recursive Fibonacci (O(2^n))
    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) +
                fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(n))
    public static long fibonacciIterative(int n) {

        if (n <= 1)
            return n;

        long a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    // ==============================
    // Performance Test
    // ==============================
    public static void testFibonacci(int n) {

        System.out.println("\nFibonacci N = " + n);

        // Recursive Timing
        if (n <= 40) {   // avoid extreme delay
            long startRec = System.nanoTime();
            long resultRec = fibonacciRecursive(n);
            long endRec = System.nanoTime();

            System.out.println("Recursive Result: " + resultRec);
            System.out.println("Recursive Time: " +
                    (endRec - startRec) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Recursive: Skipped (Too Slow)");
        }

        // Iterative Timing
        long startIter = System.nanoTime();
        long resultIter = fibonacciIterative(n);
        long endIter = System.nanoTime();

        System.out.println("Iterative Result: " + resultIter);
        System.out.println("Iterative Time: " +
                (endIter - startIter) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {

        testFibonacci(10);
        testFibonacci(30);
        testFibonacci(45);
    }
}
