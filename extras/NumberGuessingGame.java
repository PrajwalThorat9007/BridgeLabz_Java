package extras;

import java.util.*;

/**
 * Problem 1: Number Guessing Game
 * Computer tries to guess a number between 1 and 100 that the user is thinking of
 * User provides feedback: high, low, or correct
 */
public class NumberGuessingGame {
    
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Generate a random guess within the current range
     */
    public static int generateRandomGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Generate an intelligent guess using binary search strategy
     */
    public static int generateSmartGuess(int min, int max) {
        return (min + max) / 2;
    }
    
    /**
     * Get user feedback for the guess
     * @return 1 if guess is too high, -1 if too low, 0 if correct
     */
    public static int getUserFeedback(int guess) {
        System.out.println("\nComputer's guess: " + guess);
        System.out.println("Is this guess:");
        System.out.println("  1. Too HIGH");
        System.out.println("  2. Too LOW");
        System.out.println("  3. CORRECT");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1: return 1;  // Too high
            case 2: return -1; // Too low
            case 3: return 0;  // Correct
            default:
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                return getUserFeedback(guess);
        }
    }
    
    /**
     * Adjust the range based on feedback
     */
    public static int[] adjustRange(int guess, int feedback, int min, int max) {
        if (feedback == 1) {
            // Guess was too high, adjust max
            max = guess - 1;
        } else if (feedback == -1) {
            // Guess was too low, adjust min
            min = guess + 1;
        }
        return new int[]{min, max};
    }
    
    /**
     * Play the game using random guessing strategy
     */
    public static void playRandomStrategy() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("RANDOM GUESSING STRATEGY");
        System.out.println("═".repeat(70));
        System.out.println("\nThink of a number between " + MIN_RANGE + " and " + MAX_RANGE);
        System.out.println("I will try to guess it using RANDOM guesses!");
        System.out.print("Press Enter when ready...");
        scanner.nextLine();
        
        int min = MIN_RANGE;
        int max = MAX_RANGE;
        int attempts = 0;
        int guess;
        int feedback;
        List<Integer> guessHistory = new ArrayList<>();
        
        do {
            attempts++;
            guess = generateRandomGuess(min, max);
            guessHistory.add(guess);
            
            System.out.println("\n--- Attempt " + attempts + " ---");
            System.out.println("Current range: [" + min + " - " + max + "]");
            
            feedback = getUserFeedback(guess);
            
            if (feedback != 0) {
                int[] newRange = adjustRange(guess, feedback, min, max);
                min = newRange[0];
                max = newRange[1];
                
                if (min > max) {
                    System.out.println("\n⚠ Warning: Invalid feedback detected!");
                    System.out.println("The range has become impossible. Please be honest!");
                    return;
                }
            }
            
        } while (feedback != 0);
        
        displayResults(guess, attempts, guessHistory);
    }
    
    /**
     * Play the game using smart (binary search) strategy
     */
    public static void playSmartStrategy() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("SMART GUESSING STRATEGY (Binary Search)");
        System.out.println("═".repeat(70));
        System.out.println("\nThink of a number between " + MIN_RANGE + " and " + MAX_RANGE);
        System.out.println("I will try to guess it using BINARY SEARCH!");
        System.out.print("Press Enter when ready...");
        scanner.nextLine();
        
        int min = MIN_RANGE;
        int max = MAX_RANGE;
        int attempts = 0;
        int guess;
        int feedback;
        List<Integer> guessHistory = new ArrayList<>();
        
        do {
            attempts++;
            guess = generateSmartGuess(min, max);
            guessHistory.add(guess);
            
            System.out.println("\n--- Attempt " + attempts + " ---");
            System.out.println("Current range: [" + min + " - " + max + "]");
            
            feedback = getUserFeedback(guess);
            
            if (feedback != 0) {
                int[] newRange = adjustRange(guess, feedback, min, max);
                min = newRange[0];
                max = newRange[1];
                
                if (min > max) {
                    System.out.println("\n⚠ Warning: Invalid feedback detected!");
                    System.out.println("The range has become impossible. Please be honest!");
                    return;
                }
            }
            
        } while (feedback != 0);
        
        displayResults(guess, attempts, guessHistory);
    }
    
    /**
     * Display game results
     */
    public static void displayResults(int correctNumber, int attempts, List<Integer> guessHistory) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("🎉 GAME OVER - I GUESSED IT!");
        System.out.println("═".repeat(70));
        System.out.println("\nYour number was: " + correctNumber);
        System.out.println("Number of attempts: " + attempts);
        System.out.println("\nGuess History: " + guessHistory);
        
        // Calculate statistics
        int maxPossibleAttempts = (int) Math.ceil(Math.log(MAX_RANGE - MIN_RANGE + 1) / Math.log(2));
        System.out.println("\nStatistics:");
        System.out.println("  Best possible (binary search): " + maxPossibleAttempts + " attempts");
        System.out.println("  Actual attempts: " + attempts);
        
        if (attempts <= maxPossibleAttempts) {
            System.out.println("  Performance: ⭐ EXCELLENT!");
        } else if (attempts <= maxPossibleAttempts + 3) {
            System.out.println("  Performance: ✓ GOOD");
        } else {
            System.out.println("  Performance: ○ AVERAGE");
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Automated game for testing (computer plays both roles)
     */
    public static void playAutomatedGame(int secretNumber) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("AUTOMATED GAME DEMONSTRATION");
        System.out.println("═".repeat(70));
        System.out.println("\nSecret number: " + secretNumber);
        System.out.println("Strategy: Binary Search");
        
        int min = MIN_RANGE;
        int max = MAX_RANGE;
        int attempts = 0;
        int guess;
        List<Integer> guessHistory = new ArrayList<>();
        
        while (true) {
            attempts++;
            guess = generateSmartGuess(min, max);
            guessHistory.add(guess);
            
            System.out.println("\n--- Attempt " + attempts + " ---");
            System.out.println("Range: [" + min + " - " + max + "]");
            System.out.println("Guess: " + guess);
            
            if (guess == secretNumber) {
                System.out.println("Feedback: ✓ CORRECT!");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Feedback: ↓ Too HIGH");
                max = guess - 1;
            } else {
                System.out.println("Feedback: ↑ Too LOW");
                min = guess + 1;
            }
            
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                // Ignore
            }
        }
        
        displayResults(guess, attempts, guessHistory);
    }
    
    /**
     * Compare random vs smart strategy
     */
    public static void compareStrategies() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("STRATEGY COMPARISON");
        System.out.println("═".repeat(70));
        
        Random random = new Random();
        int trials = 10;
        int totalRandomAttempts = 0;
        int totalSmartAttempts = 0;
        
        System.out.println("\nRunning " + trials + " trials...\n");
        
        for (int i = 1; i <= trials; i++) {
            int secretNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            
            // Random strategy
            int randomAttempts = simulateRandomStrategy(secretNumber);
            totalRandomAttempts += randomAttempts;
            
            // Smart strategy
            int smartAttempts = simulateSmartStrategy(secretNumber);
            totalSmartAttempts += smartAttempts;
            
            System.out.printf("Trial %2d (Number: %3d) - Random: %2d attempts, Smart: %2d attempts%n",
                            i, secretNumber, randomAttempts, smartAttempts);
        }
        
        System.out.println("\n" + "─".repeat(70));
        System.out.println("Results:");
        System.out.printf("  Random Strategy - Average: %.1f attempts%n", 
                        (double) totalRandomAttempts / trials);
        System.out.printf("  Smart Strategy  - Average: %.1f attempts%n", 
                        (double) totalSmartAttempts / trials);
        System.out.println("═".repeat(70));
    }
    
    /**
     * Simulate random strategy
     */
    private static int simulateRandomStrategy(int secretNumber) {
        int min = MIN_RANGE;
        int max = MAX_RANGE;
        int attempts = 0;
        
        while (true) {
            attempts++;
            int guess = generateRandomGuess(min, max);
            
            if (guess == secretNumber) {
                break;
            } else if (guess > secretNumber) {
                max = guess - 1;
            } else {
                min = guess + 1;
            }
            
            if (attempts > 100) break; // Safety limit
        }
        
        return attempts;
    }
    
    /**
     * Simulate smart strategy
     */
    private static int simulateSmartStrategy(int secretNumber) {
        int min = MIN_RANGE;
        int max = MAX_RANGE;
        int attempts = 0;
        
        while (true) {
            attempts++;
            int guess = generateSmartGuess(min, max);
            
            if (guess == secretNumber) {
                break;
            } else if (guess > secretNumber) {
                max = guess - 1;
            } else {
                min = guess + 1;
            }
        }
        
        return attempts;
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(21) + "NUMBER GUESSING GAME" + " ".repeat(27) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        while (true) {
            System.out.println("\n" + "═".repeat(70));
            System.out.println("MAIN MENU");
            System.out.println("═".repeat(70));
            System.out.println("\n1. Play with Random Guessing Strategy");
            System.out.println("2. Play with Smart Guessing Strategy (Binary Search)");
            System.out.println("3. Watch Automated Game Demonstration");
            System.out.println("4. Compare Strategies");
            System.out.println("0. Exit");
            
            System.out.print("\nEnter your choice (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    playRandomStrategy();
                    break;
                    
                case 2:
                    playSmartStrategy();
                    break;
                    
                case 3:
                    System.out.print("\nEnter a number between 1-100 for demonstration: ");
                    int demoNumber = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (demoNumber < MIN_RANGE || demoNumber > MAX_RANGE) {
                        System.out.println("Invalid number! Must be between " + 
                                         MIN_RANGE + " and " + MAX_RANGE);
                    } else {
                        playAutomatedGame(demoNumber);
                    }
                    break;
                    
                case 4:
                    compareStrategies();
                    break;
                    
                case 0:
                    System.out.println("\nThank you for playing!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("\nInvalid choice! Please enter 0-4.");
            }
        }
    }
}
