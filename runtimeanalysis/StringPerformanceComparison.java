package runtimeanalysis;

public class StringPerformanceComparison {
    public static void testPerformance(int n) {

        System.out.println("\nOperations Count: " + n);

        // Using String (Immutable)
        if (n <= 100000) {   // prevent extreme delay
            long startString = System.nanoTime();

            String str = "";
            for (int i = 0; i < n; i++) {
                str = str + "a";
            }

            long endString = System.nanoTime();
            System.out.println("String Time: " +
                    (endString - startString) / 1_000_000.0 + " ms");
        } else {
            System.out.println("String Time: Skipped (Too Slow)");
        }

        // Using StringBuilder
        long startBuilder = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder Time: " +
                (endBuilder - startBuilder) / 1_000_000.0 + " ms");

        //  Using StringBuffer
        long startBuffer = System.nanoTime();

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }

        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer Time: " +
                (endBuffer - startBuffer) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {

        testPerformance(1000);
        testPerformance(10000);
        testPerformance(1000000);
    }
}
