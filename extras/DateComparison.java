package extras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Problem 4: Date Comparison
 * Compare two dates to check if the first date is before, after, or the same as the second date
 */
public class DateComparison {
    
    /**
     * Compare two dates and display result
     */
    public static void compareDates(LocalDate date1, LocalDate date2) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE COMPARISON");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy (EEEE)");
        
        System.out.println("\nDate 1: " + date1.format(formatter));
        System.out.println("Date 2: " + date2.format(formatter));
        System.out.println();
        
        System.out.println("Comparison Results:");
        System.out.println("─".repeat(70));
        
        // Using isBefore()
        boolean isBefore = date1.isBefore(date2);
        System.out.printf("  date1.isBefore(date2)  : %s%n", isBefore);
        
        // Using isAfter()
        boolean isAfter = date1.isAfter(date2);
        System.out.printf("  date1.isAfter(date2)   : %s%n", isAfter);
        
        // Using isEqual()
        boolean isEqual = date1.isEqual(date2);
        System.out.printf("  date1.isEqual(date2)   : %s%n", isEqual);
        
        System.out.println();
        System.out.println("Result: ");
        if (isEqual) {
            System.out.println("  ✓ Both dates are THE SAME");
        } else if (isBefore) {
            System.out.println("  ✓ Date 1 is BEFORE Date 2");
        } else {
            System.out.println("  ✓ Date 1 is AFTER Date 2");
        }
        
        // Calculate difference
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("\nDifference: " + Math.abs(daysBetween) + " days");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Compare dates using compareTo method
     */
    public static void compareUsingCompareTo(LocalDate date1, LocalDate date2) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("COMPARISON USING compareTo() METHOD");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nDate 1: " + date1.format(formatter));
        System.out.println("Date 2: " + date2.format(formatter));
        System.out.println();
        
        int comparison = date1.compareTo(date2);
        
        System.out.println("date1.compareTo(date2) = " + comparison);
        System.out.println();
        
        if (comparison < 0) {
            System.out.println("Result: Date 1 is BEFORE Date 2 (negative value)");
        } else if (comparison > 0) {
            System.out.println("Result: Date 1 is AFTER Date 2 (positive value)");
        } else {
            System.out.println("Result: Both dates are EQUAL (zero value)");
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Compare multiple dates and sort them
     */
    public static void compareAndSortDates(LocalDate... dates) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("COMPARE AND SORT MULTIPLE DATES");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nOriginal Order:");
        for (int i = 0; i < dates.length; i++) {
            System.out.println("  " + (i + 1) + ". " + dates[i].format(formatter));
        }
        
        // Sort dates
        LocalDate[] sortedDates = Arrays.copyOf(dates, dates.length);
        Arrays.sort(sortedDates);
        
        System.out.println("\nSorted Order (Ascending):");
        for (int i = 0; i < sortedDates.length; i++) {
            System.out.println("  " + (i + 1) + ". " + sortedDates[i].format(formatter));
        }
        
        // Find earliest and latest
        LocalDate earliest = sortedDates[0];
        LocalDate latest = sortedDates[sortedDates.length - 1];
        
        System.out.println("\nEarliest Date: " + earliest.format(formatter));
        System.out.println("Latest Date:   " + latest.format(formatter));
        
        long span = ChronoUnit.DAYS.between(earliest, latest);
        System.out.println("Time Span:     " + span + " days");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Check if date is within a range
     */
    public static void checkDateInRange(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("CHECK IF DATE IS WITHIN RANGE");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nDate to Check: " + dateToCheck.format(formatter));
        System.out.println("Start Date:    " + startDate.format(formatter));
        System.out.println("End Date:      " + endDate.format(formatter));
        System.out.println();
        
        boolean isWithinRange = !dateToCheck.isBefore(startDate) && 
                               !dateToCheck.isAfter(endDate);
        
        if (isWithinRange) {
            System.out.println("✓ The date IS within the range");
        } else {
            System.out.println("✗ The date is NOT within the range");
        }
        
        // Additional information
        if (dateToCheck.isBefore(startDate)) {
            long daysBefore = ChronoUnit.DAYS.between(dateToCheck, startDate);
            System.out.println("  → " + daysBefore + " days before the start date");
        } else if (dateToCheck.isAfter(endDate)) {
            long daysAfter = ChronoUnit.DAYS.between(endDate, dateToCheck);
            System.out.println("  → " + daysAfter + " days after the end date");
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Compare dates with detailed analysis
     */
    public static void detailedComparison(LocalDate date1, LocalDate date2) {
        System.out.println("\n┌" + "─".repeat(68) + "┐");
        System.out.println("│  DETAILED DATE COMPARISON" + " ".repeat(42) + "│");
        System.out.println("├" + "─".repeat(68) + "┤");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.printf("│  Date 1: %-57s │%n", date1.format(formatter));
        System.out.printf("│  Date 2: %-57s │%n", date2.format(formatter));
        System.out.println("├" + "─".repeat(68) + "┤");
        
        // Days difference
        long days = ChronoUnit.DAYS.between(date1, date2);
        System.out.printf("│  Days Difference:     %-42d │%n", Math.abs(days));
        
        // Weeks difference
        long weeks = ChronoUnit.WEEKS.between(date1, date2);
        System.out.printf("│  Weeks Difference:    %-42d │%n", Math.abs(weeks));
        
        // Months difference
        long months = ChronoUnit.MONTHS.between(date1, date2);
        System.out.printf("│  Months Difference:   %-42d │%n", Math.abs(months));
        
        // Years difference
        long years = ChronoUnit.YEARS.between(date1, date2);
        System.out.printf("│  Years Difference:    %-42d │%n", Math.abs(years));
        
        // Period
        Period period = Period.between(date1, date2);
        String periodStr = Math.abs(period.getYears()) + " years, " + 
                          Math.abs(period.getMonths()) + " months, " + 
                          Math.abs(period.getDays()) + " days";
        System.out.printf("│  Period:              %-42s │%n", periodStr);
        
        System.out.println("├" + "─".repeat(68) + "┤");
        
        // Comparison result
        String result;
        if (date1.isBefore(date2)) {
            result = "Date 1 is BEFORE Date 2";
        } else if (date1.isAfter(date2)) {
            result = "Date 1 is AFTER Date 2";
        } else {
            result = "Both dates are EQUAL";
        }
        System.out.printf("│  Result: %-55s │%n", result);
        
        System.out.println("└" + "─".repeat(68) + "┘");
    }
    
    /**
     * Compare dates relative to today
     */
    public static void compareWithToday(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("COMPARISON WITH TODAY");
        System.out.println("═".repeat(70));
        
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nToday:      " + today.format(formatter));
        System.out.println("Given Date: " + date.format(formatter));
        System.out.println();
        
        if (date.isEqual(today)) {
            System.out.println("✓ The date is TODAY");
        } else if (date.isBefore(today)) {
            long daysAgo = ChronoUnit.DAYS.between(date, today);
            System.out.println("✓ The date is in the PAST");
            System.out.println("  → " + daysAgo + " days ago");
            
            if (daysAgo == 1) {
                System.out.println("  → This was YESTERDAY");
            } else if (daysAgo <= 7) {
                System.out.println("  → Within the past week");
            } else if (daysAgo <= 30) {
                System.out.println("  → Within the past month");
            }
        } else {
            long daysAhead = ChronoUnit.DAYS.between(today, date);
            System.out.println("✓ The date is in the FUTURE");
            System.out.println("  → " + daysAhead + " days from now");
            
            if (daysAhead == 1) {
                System.out.println("  → This is TOMORROW");
            } else if (daysAhead <= 7) {
                System.out.println("  → Within the next week");
            } else if (daysAhead <= 30) {
                System.out.println("  → Within the next month");
            }
        }
        
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(25) + "DATE COMPARISON" + " ".repeat(28) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        // Test Case 1: Basic comparison
        System.out.println("\n--- Test Case 1: Basic Date Comparison ---");
        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2024, 6, 20);
        compareDates(date1, date2);
        
        // Test Case 2: Equal dates
        System.out.println("\n\n--- Test Case 2: Equal Dates ---");
        LocalDate date3 = LocalDate.of(2024, 5, 10);
        LocalDate date4 = LocalDate.of(2024, 5, 10);
        compareDates(date3, date4);
        
        // Test Case 3: Date1 after Date2
        System.out.println("\n\n--- Test Case 3: First Date After Second ---");
        LocalDate date5 = LocalDate.of(2025, 1, 1);
        LocalDate date6 = LocalDate.of(2024, 12, 31);
        compareDates(date5, date6);
        
        // Test Case 4: Using compareTo
        System.out.println("\n\n--- Test Case 4: Using compareTo() ---");
        compareUsingCompareTo(date1, date2);
        
        // Test Case 5: Compare and sort multiple dates
        System.out.println("\n\n--- Test Case 5: Sort Multiple Dates ---");
        LocalDate[] dates = {
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 1, 10),
            LocalDate.of(2024, 12, 25),
            LocalDate.of(2024, 3, 30),
            LocalDate.of(2024, 9, 5)
        };
        compareAndSortDates(dates);
        
        // Test Case 6: Date in range
        System.out.println("\n\n--- Test Case 6: Check Date in Range ---");
        LocalDate checkDate = LocalDate.of(2024, 4, 15);
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        checkDateInRange(checkDate, startDate, endDate);
        
        // Test Case 7: Detailed comparison
        System.out.println("\n\n--- Test Case 7: Detailed Comparison ---");
        detailedComparison(date1, date2);
        
        // Test Case 8: Compare with today
        System.out.println("\n\n--- Test Case 8: Compare with Today ---");
        compareWithToday(LocalDate.now().plusDays(10));
        compareWithToday(LocalDate.now().minusDays(5));
        compareWithToday(LocalDate.now());
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.println("Options:");
        System.out.println("1. Compare two dates");
        System.out.println("2. Compare date with today");
        System.out.println("3. Check if date is in range");
        System.out.println("4. Sort multiple dates");
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
                        System.out.print("Enter first date (dd/MM/yyyy): ");
                        LocalDate d1 = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        System.out.print("Enter second date (dd/MM/yyyy): ");
                        LocalDate d2 = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        
                        compareDates(d1, d2);
                        detailedComparison(d1, d2);
                        break;
                        
                    case 2:
                        System.out.print("Enter date (dd/MM/yyyy): ");
                        LocalDate dateToCompare = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        compareWithToday(dateToCompare);
                        break;
                        
                    case 3:
                        System.out.print("Enter date to check (dd/MM/yyyy): ");
                        LocalDate check = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        System.out.print("Enter start date (dd/MM/yyyy): ");
                        LocalDate start = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        System.out.print("Enter end date (dd/MM/yyyy): ");
                        LocalDate end = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        
                        checkDateInRange(check, start, end);
                        break;
                        
                    case 4:
                        System.out.print("How many dates to sort? ");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        
                        LocalDate[] datesToSort = new LocalDate[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter date " + (i + 1) + " (dd/MM/yyyy): ");
                            datesToSort[i] = LocalDate.parse(scanner.nextLine(), inputFormatter);
                        }
                        
                        compareAndSortDates(datesToSort);
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
        System.out.println("\nThank you for using Date Comparison!");
    }
}
