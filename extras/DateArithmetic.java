package extras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Problem 2: Date Arithmetic
 * Program that adds/subtracts days, months, years, and weeks to/from dates
 */
public class DateArithmetic {
    
    /**
     * Perform date arithmetic operations
     */
    public static LocalDate performDateOperations(LocalDate startDate) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE ARITHMETIC OPERATIONS");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy (EEEE)");
        
        System.out.println("\nStarting Date: " + startDate.format(formatter));
        System.out.println("─".repeat(70));
        
        // Add 7 days
        LocalDate after7Days = startDate.plusDays(7);
        System.out.println("\nStep 1: Add 7 days");
        System.out.println("  Result: " + after7Days.format(formatter));
        
        // Add 1 month
        LocalDate after1Month = after7Days.plusMonths(1);
        System.out.println("\nStep 2: Add 1 month");
        System.out.println("  Result: " + after1Month.format(formatter));
        
        // Add 2 years
        LocalDate after2Years = after1Month.plusYears(2);
        System.out.println("\nStep 3: Add 2 years");
        System.out.println("  Result: " + after2Years.format(formatter));
        
        // Subtract 3 weeks
        LocalDate finalResult = after2Years.minusWeeks(3);
        System.out.println("\nStep 4: Subtract 3 weeks");
        System.out.println("  Result: " + finalResult.format(formatter));
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("Final Result: " + finalResult.format(formatter));
        System.out.println("═".repeat(70));
        
        return finalResult;
    }
    
    /**
     * Display step-by-step date arithmetic
     */
    public static void displayStepByStepArithmetic(LocalDate startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\n┌" + "─".repeat(68) + "┐");
        System.out.println("│  STEP-BY-STEP DATE ARITHMETIC" + " ".repeat(38) + "│");
        System.out.println("├" + "─".repeat(68) + "┤");
        System.out.printf("│  %-66s │%n", "Starting Date: " + startDate.format(formatter));
        System.out.println("├" + "─".repeat(68) + "┤");
        
        LocalDate current = startDate;
        
        // Step 1: Add 7 days
        current = current.plusDays(7);
        long daysDiff = ChronoUnit.DAYS.between(startDate, current);
        System.out.printf("│  Step 1: +7 days        →  %-40s │%n", 
                        current.format(formatter) + " (+" + daysDiff + " days)");
        
        // Step 2: Add 1 month
        LocalDate beforeMonth = current;
        current = current.plusMonths(1);
        long monthsDiff = ChronoUnit.MONTHS.between(beforeMonth, current);
        System.out.printf("│  Step 2: +1 month       →  %-40s │%n",
                        current.format(formatter) + " (+" + monthsDiff + " month)");
        
        // Step 3: Add 2 years
        LocalDate beforeYears = current;
        current = current.plusYears(2);
        long yearsDiff = ChronoUnit.YEARS.between(beforeYears, current);
        System.out.printf("│  Step 3: +2 years       →  %-40s │%n",
                        current.format(formatter) + " (+" + yearsDiff + " years)");
        
        // Step 4: Subtract 3 weeks
        LocalDate beforeWeeks = current;
        current = current.minusWeeks(3);
        long weeksDiff = ChronoUnit.WEEKS.between(current, beforeWeeks);
        System.out.printf("│  Step 4: -3 weeks       →  %-40s │%n",
                        current.format(formatter) + " (-" + weeksDiff + " weeks)");
        
        System.out.println("├" + "─".repeat(68) + "┤");
        System.out.printf("│  FINAL RESULT: %-51s │%n", current.format(formatter));
        
        long totalDays = ChronoUnit.DAYS.between(startDate, current);
        System.out.printf("│  Total difference: %-46s │%n", totalDays + " days");
        
        System.out.println("└" + "─".repeat(68) + "┘");
    }
    
    /**
     * Perform various date arithmetic operations
     */
    public static void demonstrateVariousOperations(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("VARIOUS DATE ARITHMETIC OPERATIONS");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nBase Date: " + date.format(formatter));
        System.out.println();
        
        System.out.println("┌────────────────────────┬─────────────────────────┐");
        System.out.println("│      Operation         │         Result          │");
        System.out.println("├────────────────────────┼─────────────────────────┤");
        
        System.out.printf("│ Add 1 day              │ %-23s │%n", date.plusDays(1).format(formatter));
        System.out.printf("│ Add 10 days            │ %-23s │%n", date.plusDays(10).format(formatter));
        System.out.printf("│ Add 1 week             │ %-23s │%n", date.plusWeeks(1).format(formatter));
        System.out.printf("│ Add 1 month            │ %-23s │%n", date.plusMonths(1).format(formatter));
        System.out.printf("│ Add 6 months           │ %-23s │%n", date.plusMonths(6).format(formatter));
        System.out.printf("│ Add 1 year             │ %-23s │%n", date.plusYears(1).format(formatter));
        System.out.printf("│ Subtract 1 day         │ %-23s │%n", date.minusDays(1).format(formatter));
        System.out.printf("│ Subtract 2 weeks       │ %-23s │%n", date.minusWeeks(2).format(formatter));
        System.out.printf("│ Subtract 3 months      │ %-23s │%n", date.minusMonths(3).format(formatter));
        System.out.printf("│ Subtract 1 year        │ %-23s │%n", date.minusYears(1).format(formatter));
        
        System.out.println("└────────────────────────┴─────────────────────────┘");
    }
    
    /**
     * Calculate date differences
     */
    public static void calculateDateDifferences(LocalDate startDate, LocalDate endDate) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE DIFFERENCE CALCULATION");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nStart Date: " + startDate.format(formatter));
        System.out.println("End Date:   " + endDate.format(formatter));
        System.out.println();
        
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long weeks = ChronoUnit.WEEKS.between(startDate, endDate);
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        long years = ChronoUnit.YEARS.between(startDate, endDate);
        
        System.out.println("Difference:");
        System.out.println("  " + Math.abs(days) + " days");
        System.out.println("  " + Math.abs(weeks) + " weeks");
        System.out.println("  " + Math.abs(months) + " months");
        System.out.println("  " + Math.abs(years) + " years");
        
        Period period = Period.between(startDate, endDate);
        System.out.println("\nPrecise Period:");
        System.out.println("  " + Math.abs(period.getYears()) + " years, " + 
                         Math.abs(period.getMonths()) + " months, " + 
                         Math.abs(period.getDays()) + " days");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Calculate future and past dates
     */
    public static void calculateMilestoneDates(LocalDate startDate) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("MILESTONE DATES");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy (EEEE)");
        System.out.println("\nReference Date: " + startDate.format(formatter));
        System.out.println();
        
        System.out.println("Future Milestones:");
        System.out.println("  30 days from now:  " + startDate.plusDays(30).format(formatter));
        System.out.println("  90 days from now:  " + startDate.plusDays(90).format(formatter));
        System.out.println("  6 months from now: " + startDate.plusMonths(6).format(formatter));
        System.out.println("  1 year from now:   " + startDate.plusYears(1).format(formatter));
        
        System.out.println("\nPast Milestones:");
        System.out.println("  30 days ago:       " + startDate.minusDays(30).format(formatter));
        System.out.println("  90 days ago:       " + startDate.minusDays(90).format(formatter));
        System.out.println("  6 months ago:      " + startDate.minusMonths(6).format(formatter));
        System.out.println("  1 year ago:        " + startDate.minusYears(1).format(formatter));
        
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(25) + "DATE ARITHMETIC" + " ".repeat(28) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        // Test Case 1: Required operations
        System.out.println("\n--- Test Case 1: Required Date Operations ---");
        LocalDate startDate = LocalDate.now();
        LocalDate result = performDateOperations(startDate);
        
        // Test Case 2: Step-by-step visualization
        System.out.println("\n\n--- Test Case 2: Step-by-Step Visualization ---");
        displayStepByStepArithmetic(startDate);
        
        // Test Case 3: Various operations
        System.out.println("\n\n--- Test Case 3: Various Date Operations ---");
        demonstrateVariousOperations(LocalDate.now());
        
        // Test Case 4: Date differences
        System.out.println("\n\n--- Test Case 4: Calculate Date Differences ---");
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.of(2026, 6, 15);
        calculateDateDifferences(date1, date2);
        
        // Test Case 5: Milestone dates
        System.out.println("\n\n--- Test Case 5: Milestone Dates ---");
        calculateMilestoneDates(LocalDate.now());
        
        // Test Case 6: Custom date input
        System.out.println("\n\n--- Test Case 6: Custom Date Input ---");
        LocalDate customDate = LocalDate.of(2024, 3, 15);
        System.out.println("Using custom date: " + customDate);
        performDateOperations(customDate);
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.println("Options:");
        System.out.println("1. Perform standard operations (+7 days, +1 month, +2 years, -3 weeks)");
        System.out.println("2. Custom date arithmetic");
        System.out.println("3. Calculate difference between two dates");
        System.out.println("4. Calculate milestone dates");
        System.out.println("0. Exit");
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while (true) {
            System.out.print("\nEnter choice (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) break;
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter date (dd/MM/yyyy) or press Enter for today: ");
                        String dateInput = scanner.nextLine();
                        LocalDate date = dateInput.isEmpty() ? 
                                        LocalDate.now() : 
                                        LocalDate.parse(dateInput, inputFormatter);
                        displayStepByStepArithmetic(date);
                        break;
                        
                    case 2:
                        System.out.print("Enter starting date (dd/MM/yyyy): ");
                        LocalDate start = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        
                        System.out.print("Add days: ");
                        int days = scanner.nextInt();
                        System.out.print("Add months: ");
                        int months = scanner.nextInt();
                        System.out.print("Add years: ");
                        int years = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        
                        LocalDate custom = start.plusDays(days)
                                               .plusMonths(months)
                                               .plusYears(years);
                        
                        System.out.println("\nStarting Date: " + start.format(inputFormatter));
                        System.out.println("Operations: +" + days + " days, +" + 
                                         months + " months, +" + years + " years");
                        System.out.println("Result: " + custom.format(inputFormatter));
                        break;
                        
                    case 3:
                        System.out.print("Enter first date (dd/MM/yyyy): ");
                        LocalDate d1 = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        System.out.print("Enter second date (dd/MM/yyyy): ");
                        LocalDate d2 = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        
                        calculateDateDifferences(d1, d2);
                        break;
                        
                    case 4:
                        System.out.print("Enter reference date (dd/MM/yyyy) or Enter for today: ");
                        String refInput = scanner.nextLine();
                        LocalDate ref = refInput.isEmpty() ? 
                                       LocalDate.now() : 
                                       LocalDate.parse(refInput, inputFormatter);
                        
                        calculateMilestoneDates(ref);
                        break;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please use the format dd/MM/yyyy (e.g., 15/03/2024)");
            }
        }
        
        scanner.close();
        System.out.println("\nThank you for using Date Arithmetic!");
    }
}
