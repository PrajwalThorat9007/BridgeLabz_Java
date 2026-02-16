package extras;

import java.util.*;

/**
 * Problem 3: Prime Number Checker
 * Check whether a given number is a prime number using modular functions
 */
public class PrimeNumberChecker {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Check if a number is prime (Basic method)
     * Time Complexity: O(n)
     */
    public static boolean isPrimeBasic(int number) {
        if (number <= 1) {
            return false;
        }
        
        if (number == 2) {
            return true;
        }
        
        if (number % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i < number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Check if a number is prime (Optimized method - check up to sqrt)
     * Time Complexity: O(√n)
     */
    public static boolean isPrimeOptimized(int number) {
        if (number <= 1) {
            return false;
        }
        
        if (number <= 3) {
            return true;
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        // Check divisibility up to square root
        int limit = (int) Math.sqrt(number);
        for (int i = 5; i <= limit; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Check if number is prime with detailed steps
     */
    public static boolean isPrimeWithSteps(int number) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("CHECKING IF " + number + " IS PRIME");
        System.out.println("═".repeat(70));
        
        if (number <= 1) {
            System.out.println("\n✗ " + number + " is NOT prime (numbers ≤ 1 are not prime)");
            return false;
        }
        
        if (number == 2) {
            System.out.println("\n✓ 2 is PRIME (the only even prime number)");
            return true;
        }
        
        if (number % 2 == 0) {
            System.out.println("\n✗ " + number + " is NOT prime (divisible by 2)");
            return false;
        }
        
        System.out.println("\nChecking divisibility from 3 to √" + number + " (≈" + (int)Math.sqrt(number) + ")");
        System.out.println("Testing only odd numbers...\n");
        
        int limit = (int) Math.sqrt(number);
        int testsPerformed = 0;
        
        for (int i = 3; i <= limit; i += 2) {
            testsPerformed++;
            System.out.printf("  Testing %d ÷ %d = %.2f", number, i, (double)number/i);
            
            if (number % i == 0) {
                System.out.println(" → Divisible! ✗");
                System.out.println("\n✗ " + number + " is NOT prime (divisible by " + i + ")");
                System.out.println("Tests performed: " + testsPerformed);
                return false;
            } else {
                System.out.println(" → Not divisible ✓");
            }
        }
        
        System.out.println("\n✓ " + number + " is PRIME!");
        System.out.println("Tests performed: " + testsPerformed);
        return true;
    }
    
    /**
     * Get all factors of a number
     */
    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }
    
    /**
     * Display detailed analysis of a number
     */
    public static void analyzeNumber(int number) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("NUMBER ANALYSIS: " + number);
        System.out.println("═".repeat(70));
        
        boolean isPrime = isPrimeOptimized(number);
        
        System.out.println("\nBasic Properties:");
        System.out.println("  Number:        " + number);
        System.out.println("  Prime:         " + (isPrime ? "YES ✓" : "NO ✗"));
        System.out.println("  Even/Odd:      " + (number % 2 == 0 ? "Even" : "Odd"));
        
        if (number > 1) {
            List<Integer> factors = getFactors(number);
            System.out.println("  Factor Count:  " + factors.size());
            System.out.println("  Factors:       " + factors);
            
            if (!isPrime) {
                // Find prime factorization
                List<Integer> primeFactors = getPrimeFactorization(number);
                System.out.println("  Prime Factors: " + primeFactors);
            }
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Get prime factorization of a number
     */
    public static List<Integer> getPrimeFactorization(int number) {
        List<Integer> factors = new ArrayList<>();
        
        // Divide by 2
        while (number % 2 == 0) {
            factors.add(2);
            number /= 2;
        }
        
        // Divide by odd numbers
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        
        // If number > 2, it's a prime factor
        if (number > 2) {
            factors.add(number);
        }
        
        return factors;
    }
    
    /**
     * Find all prime numbers up to n (Sieve of Eratosthenes)
     */
    public static List<Integer> findPrimesUpTo(int n) {
        List<Integer> primes = new ArrayList<>();
        
        if (n < 2) {
            return primes;
        }
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    /**
     * Display prime numbers in a range
     */
    public static void displayPrimesInRange(int start, int end) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("PRIME NUMBERS FROM " + start + " TO " + end);
        System.out.println("═".repeat(70));
        
        List<Integer> primes = new ArrayList<>();
        
        for (int i = start; i <= end; i++) {
            if (isPrimeOptimized(i)) {
                primes.add(i);
            }
        }
        
        System.out.println("\nPrimes found: " + primes.size());
        System.out.println("\n" + primes);
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Find next prime after given number
     */
    public static int findNextPrime(int number) {
        int candidate = number + 1;
        
        while (!isPrimeOptimized(candidate)) {
            candidate++;
        }
        
        return candidate;
    }
    
    /**
     * Find previous prime before given number
     */
    public static int findPreviousPrime(int number) {
        if (number <= 2) {
            return -1; // No prime before 2
        }
        
        int candidate = number - 1;
        
        while (candidate >= 2 && !isPrimeOptimized(candidate)) {
            candidate--;
        }
        
        return candidate >= 2 ? candidate : -1;
    }
    
    /**
     * Performance comparison of different methods
     */
    public static void comparePerformance() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("═".repeat(70));
        
        int[] testNumbers = {1009, 10007, 100003, 1000003};
        
        System.out.println("\n┌────────────┬──────────────┬──────────────┐");
        System.out.println("│   Number   │  Basic (ms)  │ Optimized(ms)│");
        System.out.println("├────────────┼──────────────┼──────────────┤");
        
        for (int number : testNumbers) {
            // Basic method
            long start = System.nanoTime();
            boolean result1 = isPrimeBasic(number);
            long basicTime = System.nanoTime() - start;
            
            // Optimized method
            start = System.nanoTime();
            boolean result2 = isPrimeOptimized(number);
            long optimizedTime = System.nanoTime() - start;
            
            System.out.printf("│ %10d │    %8.4f  │    %8.4f  │%n", 
                            number, basicTime / 1_000_000.0, optimizedTime / 1_000_000.0);
        }
        
        System.out.println("└────────────┴──────────────┴──────────────┘");
        System.out.println("═".repeat(70));
    }
    
    /**
     * Test various numbers
     */
    public static void testVariousNumbers() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("TEST VARIOUS NUMBERS");
        System.out.println("═".repeat(70));
        
        int[] testCases = {-5, 0, 1, 2, 3, 4, 5, 10, 17, 25, 29, 100, 101, 997};
        
        System.out.println("\n┌────────────┬──────────────┐");
        System.out.println("│   Number   │    Prime?    │");
        System.out.println("├────────────┼──────────────┤");
        
        for (int number : testCases) {
            boolean isPrime = isPrimeOptimized(number);
            System.out.printf("│ %10d │      %s      │%n", 
                            number, isPrime ? "YES ✓" : "NO ✗ ");
        }
        
        System.out.println("└────────────┴──────────────┘");
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display first N prime numbers
     */
    public static void displayFirstNPrimes(int n) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("FIRST " + n + " PRIME NUMBERS");
        System.out.println("═".repeat(70));
        
        List<Integer> primes = new ArrayList<>();
        int candidate = 2;
        
        while (primes.size() < n) {
            if (isPrimeOptimized(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
        
        // Display in rows of 10
        System.out.println();
        for (int i = 0; i < primes.size(); i++) {
            System.out.printf("%6d", primes.get(i));
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        
        System.out.println("\n\nLargest prime: " + primes.get(primes.size() - 1));
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(22) + "PRIME NUMBER CHECKER" + " ".repeat(26) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        while (true) {
            System.out.println("\n" + "═".repeat(70));
            System.out.println("MAIN MENU");
            System.out.println("═".repeat(70));
            System.out.println("\n1. Check if a number is prime");
            System.out.println("2. Check with step-by-step explanation");
            System.out.println("3. Analyze a number");
            System.out.println("4. Find primes in a range");
            System.out.println("5. Find next/previous prime");
            System.out.println("6. Display first N primes");
            System.out.println("7. Test various numbers");
            System.out.println("8. Performance comparison");
            System.out.println("0. Exit");
            
            System.out.print("\nEnter your choice (0-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) {
                System.out.println("\nThank you!");
                scanner.close();
                return;
            }
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter a number: ");
                    int num1 = scanner.nextInt();
                    boolean isPrime = isPrimeOptimized(num1);
                    System.out.println("\n" + num1 + " is " + 
                                     (isPrime ? "PRIME ✓" : "NOT PRIME ✗"));
                    break;
                    
                case 2:
                    System.out.print("\nEnter a number: ");
                    int num2 = scanner.nextInt();
                    isPrimeWithSteps(num2);
                    break;
                    
                case 3:
                    System.out.print("\nEnter a number: ");
                    int num3 = scanner.nextInt();
                    analyzeNumber(num3);
                    break;
                    
                case 4:
                    System.out.print("\nEnter start: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end: ");
                    int end = scanner.nextInt();
                    displayPrimesInRange(start, end);
                    break;
                    
                case 5:
                    System.out.print("\nEnter a number: ");
                    int num5 = scanner.nextInt();
                    int next = findNextPrime(num5);
                    int prev = findPreviousPrime(num5);
                    
                    System.out.println("\nGiven number: " + num5);
                    System.out.println("Previous prime: " + (prev == -1 ? "None" : prev));
                    System.out.println("Next prime:     " + next);
                    break;
                    
                case 6:
                    System.out.print("\nHow many primes to display? ");
                    int n = scanner.nextInt();
                    displayFirstNPrimes(n);
                    break;
                    
                case 7:
                    testVariousNumbers();
                    break;
                    
                case 8:
                    comparePerformance();
                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please enter 0-8.");
            }
        }
    }
}
