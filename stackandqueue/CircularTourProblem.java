package stackandqueue;

import java.util.*;

/**
 * Problem 5: Circular Tour Problem
 * Given a set of petrol pumps with petrol and distance to the next pump,
 * determine the starting point for completing a circular tour.
 */

    /**
     * Class to represent a Petrol Pump
     */
    static class PetrolPump {
        int petrol;    // Amount of petrol at this pump
        int distance;  // Distance to next pump
        
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
        
        @Override
        public String toString() {
            return String.format("(P:%d, D:%d)", petrol, distance);
        }
    }
    
    /**
     * Find starting point for circular tour using queue (optimized)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param pumps Array of petrol pumps
     * @return Starting pump index, or -1 if tour not possible
     */
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;          // Starting index
        int currentPetrol = 0;  // Current petrol in tank
        int totalShortage = 0;  // Total petrol shortage
        
        for (int i = 0; i < n; i++) {
            // Add petrol from current pump and subtract distance to next
            currentPetrol += pumps[i].petrol - pumps[i].distance;
            
            // If we can't reach next pump from current start
            if (currentPetrol < 0) {
                // Add to total shortage
                totalShortage += currentPetrol;
                // Try next pump as starting point
                start = i + 1;
                // Reset current petrol
                currentPetrol = 0;
            }
        }
        
        // Check if total petrol is sufficient for complete tour
        if (currentPetrol + totalShortage >= 0) {
            return start;
        }
        
        return -1; // Tour not possible
    }
    
    /**
     * Find starting point using brute force approach
     * Time Complexity: O(n^2)
     */
    public static int findStartingPointBruteForce(PetrolPump[] pumps) {
        int n = pumps.length;
        
        // Try each pump as starting point
        for (int start = 0; start < n; start++) {
            int petrol = 0;
            int count = 0;
            int current = start;
            
            // Try to complete the tour
            while (count < n) {
                petrol += pumps[current].petrol;
                
                // Check if we can reach next pump
                if (petrol < pumps[current].distance) {
                    break; // Can't reach next pump
                }
                
                petrol -= pumps[current].distance;
                current = (current + 1) % n;
                count++;
            }
            
            // If we completed the tour
            if (count == n) {
                return start;
            }
        }
        
        return -1; // Tour not possible
    }
    
    /**
     * Verify if tour is possible from given start
     */
    public static boolean verifyTour(PetrolPump[] pumps, int start) {
        if (start < 0 || start >= pumps.length) {
            return false;
        }
        
        int n = pumps.length;
        int petrol = 0;
        int current = start;
        
        for (int i = 0; i < n; i++) {
            petrol += pumps[current].petrol;
            
            if (petrol < pumps[current].distance) {
                return false;
            }
            
            petrol -= pumps[current].distance;
            current = (current + 1) % n;
        }
        
        return true;
    }
    
    /**
     * Display petrol pumps in tabular format
     */
    public static void displayPumps(PetrolPump[] pumps) {
        System.out.println("\n┌────────┬──────────┬──────────┬──────────┐");
        System.out.println("│ Pump # │  Petrol  │ Distance │  Balance │");
        System.out.println("├────────┼──────────┼──────────┼──────────┤");
        
        for (int i = 0; i < pumps.length; i++) {
            int balance = pumps[i].petrol - pumps[i].distance;
            String balanceStr = (balance >= 0 ? "+" : "") + balance;
            System.out.printf("│   %-4d │   %-6d │   %-6d │  %-7s │%n", 
                            i, pumps[i].petrol, pumps[i].distance, balanceStr);
        }
        
        System.out.println("└────────┴──────────┴──────────┴──────────┘");
    }
    
    /**
     * Simulate and display complete tour
     */
    public static void simulateTour(PetrolPump[] pumps, int start) {
        System.out.println("\n=== Tour Simulation Starting from Pump " + start + " ===");
        System.out.println("─".repeat(70));
        
        int n = pumps.length;
        int petrol = 0;
        int current = start;
        
        for (int i = 0; i < n; i++) {
            System.out.printf("Step %d: At Pump %d%n", (i + 1), current);
            System.out.printf("  Current petrol: %d%n", petrol);
            System.out.printf("  Fill petrol: +%d%n", pumps[current].petrol);
            
            petrol += pumps[current].petrol;
            System.out.printf("  After filling: %d%n", petrol);
            
            int nextPump = (current + 1) % n;
            System.out.printf("  Distance to pump %d: %d%n", nextPump, pumps[current].distance);
            
            if (petrol < pumps[current].distance) {
                System.out.println("  ✗ NOT ENOUGH PETROL!");
                System.out.println("─".repeat(70));
                return;
            }
            
            petrol -= pumps[current].distance;
            System.out.printf("  After travel: %d%n", petrol);
            System.out.printf("  ✓ Reached pump %d successfully%n", nextPump);
            System.out.println();
            
            current = nextPump;
        }
        
        System.out.println("✓ TOUR COMPLETED SUCCESSFULLY!");
        System.out.println("─".repeat(70));
    }
    
    /**
     * Visualize circular tour
     */
    public static void visualizeCircularTour(PetrolPump[] pumps, int start) {
        System.out.println("\nCircular Tour Visualization:");
        System.out.println();
        
        int n = pumps.length;
        int radius = 8;
        int centerX = 40;
        int centerY = 10;
        
        // Create 2D array for visualization
        char[][] display = new char[21][80];
        for (char[] row : display) {
            Arrays.fill(row, ' ');
        }
        
        // Place pumps in circular arrangement
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n - Math.PI / 2;
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            
            String label = "P" + i;
            if (i == start) {
                label = "[P" + i + "]"; // Mark starting pump
            }
            
            for (int j = 0; j < label.length() && x + j < 80; j++) {
                display[y][x + j] = label.charAt(j);
            }
        }
        
        // Print display
        for (char[] row : display) {
            System.out.println(new String(row));
        }
        
        System.out.println("\n[Px] = Starting pump");
        System.out.println("Px = Other pumps");
    }
    
    /**
     * Display detailed analysis
     */
    public static void analyzeCircularTour(PetrolPump[] pumps) {
        System.out.println("\nCircular Tour Analysis:");
        System.out.println("─".repeat(70));
        
        int totalPetrol = 0;
        int totalDistance = 0;
        
        for (PetrolPump pump : pumps) {
            totalPetrol += pump.petrol;
            totalDistance += pump.distance;
        }
        
        System.out.println("Total Petrol Available: " + totalPetrol);
        System.out.println("Total Distance to Cover: " + totalDistance);
        System.out.println("Net Balance: " + (totalPetrol - totalDistance));
        
        if (totalPetrol >= totalDistance) {
            System.out.println("✓ Tour is POSSIBLE (sufficient petrol)");
        } else {
            System.out.println("✗ Tour is IMPOSSIBLE (insufficient petrol)");
        }
        
        System.out.println("─".repeat(70));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(16) + "CIRCULAR TOUR PROBLEM" + " ".repeat(21) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Standard example - Tour possible
        System.out.println("\n--- Test Case 1: Tour Possible ---");
        PetrolPump[] pumps1 = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        
        displayPumps(pumps1);
        analyzeCircularTour(pumps1);
        
        int start1 = findStartingPoint(pumps1);
        if (start1 != -1) {
            System.out.println("\n✓ Starting pump found: Pump " + start1);
            System.out.println("Verification: " + (verifyTour(pumps1, start1) ? "PASSED" : "FAILED"));
            simulateTour(pumps1, start1);
            visualizeCircularTour(pumps1, start1);
        } else {
            System.out.println("\n✗ No valid starting point exists!");
        }
        
        // Test Case 2: Tour not possible
        System.out.println("\n\n--- Test Case 2: Tour NOT Possible ---");
        PetrolPump[] pumps2 = {
            new PetrolPump(2, 5),
            new PetrolPump(3, 6),
            new PetrolPump(1, 4)
        };
        
        displayPumps(pumps2);
        analyzeCircularTour(pumps2);
        
        int start2 = findStartingPoint(pumps2);
        if (start2 != -1) {
            System.out.println("\n✓ Starting pump: Pump " + start2);
        } else {
            System.out.println("\n✗ Tour is IMPOSSIBLE - insufficient total petrol!");
        }
        
        // Test Case 3: Multiple pumps
        System.out.println("\n\n--- Test Case 3: Larger Circuit ---");
        PetrolPump[] pumps3 = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3),
            new PetrolPump(4, 2),
            new PetrolPump(5, 5),
            new PetrolPump(8, 6)
        };
        
        displayPumps(pumps3);
        analyzeCircularTour(pumps3);
        
        int start3 = findStartingPoint(pumps3);
        if (start3 != -1) {
            System.out.println("\n✓ Starting pump: Pump " + start3);
            System.out.println("Verification: " + (verifyTour(pumps3, start3) ? "PASSED" : "FAILED"));
            simulateTour(pumps3, start3);
        }
        
        // Test Case 4: All pumps have equal petrol and distance
        System.out.println("\n\n--- Test Case 4: Balanced Circuit ---");
        PetrolPump[] pumps4 = {
            new PetrolPump(5, 5),
            new PetrolPump(5, 5),
            new PetrolPump(5, 5),
            new PetrolPump(5, 5)
        };
        
        displayPumps(pumps4);
        analyzeCircularTour(pumps4);
        
        int start4 = findStartingPoint(pumps4);
        System.out.println("\n✓ Starting pump: Pump " + start4);
        System.out.println("Note: Any pump can be starting point in balanced circuit!");
        
        // Test Case 5: Single pump
        System.out.println("\n\n--- Test Case 5: Single Pump ---");
        PetrolPump[] pumps5 = {
            new PetrolPump(10, 5)
        };
        
        displayPumps(pumps5);
        analyzeCircularTour(pumps5);
        
        int start5 = findStartingPoint(pumps5);
        if (start5 != -1) {
            System.out.println("\n✓ Starting pump: Pump " + start5);
            simulateTour(pumps5, start5);
        }
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        PetrolPump[] largePumps = new PetrolPump[1000];
        Random rand = new Random(42);
        for (int i = 0; i < largePumps.length; i++) {
            largePumps[i] = new PetrolPump(
                rand.nextInt(20) + 10,  // Petrol: 10-29
                rand.nextInt(15) + 5    // Distance: 5-19
            );
        }
        
        long startTime = System.nanoTime();
        int resultOptimized = findStartingPoint(largePumps);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int resultBrute = findStartingPointBruteForce(largePumps);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Number of pumps: " + largePumps.length);
        System.out.printf("Optimized approach: %.3f ms (Result: Pump %d)%n", 
                         optimizedTime / 1_000_000.0, resultOptimized);
        System.out.printf("Brute force approach: %.3f ms (Result: Pump %d)%n", 
                         bruteTime / 1_000_000.0, resultBrute);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
        System.out.println("Results match: " + (resultOptimized == resultBrute ? "YES" : "NO"));
    }
}
