package extras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.*;

/**
 * Problem 3: Date Formatting
 * Display the current date in different formats
 */
public class DateFormatting {
    
    /**
     * Display date in three required formats
     */
    public static void displayInThreeFormats(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE IN THREE REQUIRED FORMATS");
        System.out.println("═".repeat(70));
        
        // Format 1: dd/MM/yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted1 = date.format(format1);
        
        // Format 2: yyyy-MM-dd
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted2 = date.format(format2);
        
        // Format 3: EEE, MMM dd, yyyy
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        String formatted3 = date.format(format3);
        
        System.out.println("\nOriginal Date: " + date);
        System.out.println();
        System.out.println("┌────────────────────────────┬─────────────────────────┐");
        System.out.println("│       Format Pattern       │         Result          │");
        System.out.println("├────────────────────────────┼─────────────────────────┤");
        System.out.printf("│ dd/MM/yyyy                 │ %-23s │%n", formatted1);
        System.out.printf("│ yyyy-MM-dd                 │ %-23s │%n", formatted2);
        System.out.printf("│ EEE, MMM dd, yyyy          │ %-23s │%n", formatted3);
        System.out.println("└────────────────────────────┴─────────────────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display date in various formats
     */
    public static void displayVariousFormats(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE IN VARIOUS FORMATS");
        System.out.println("═".repeat(70));
        
        System.out.println("\nOriginal Date: " + date);
        System.out.println();
        
        String[][] formats = {
            {"dd/MM/yyyy", "Day/Month/Year"},
            {"dd-MM-yyyy", "Day-Month-Year"},
            {"dd.MM.yyyy", "Day.Month.Year"},
            {"yyyy-MM-dd", "ISO 8601"},
            {"MM/dd/yyyy", "US Format"},
            {"dd MMM yyyy", "Day Month Year"},
            {"dd MMMM yyyy", "Day Full Month Year"},
            {"EEE, dd MMM yyyy", "Weekday, Day Month Year"},
            {"EEEE, MMMM dd, yyyy", "Full Weekday, Full Month"},
            {"dd/MM/yy", "Short Year"},
            {"d/M/yyyy", "No Leading Zeros"},
            {"'Date:' dd-MM-yyyy", "With Text"},
            {"yyyy 'Year' MM 'Month' dd 'Day'", "Descriptive"}
        };
        
        System.out.println("┌────────────────────────────────┬─────────────────────────────┐");
        System.out.println("│        Format Pattern          │           Result            │");
        System.out.println("├────────────────────────────────┼─────────────────────────────┤");
        
        for (String[] format : formats) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format[0]);
            String result = date.format(formatter);
            System.out.printf("│ %-30s │ %-27s │%n", format[0], result);
        }
        
        System.out.println("└────────────────────────────────┴─────────────────────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display date with time in various formats
     */
    public static void displayDateTimeFormats(LocalDateTime dateTime) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("DATE AND TIME IN VARIOUS FORMATS");
        System.out.println("═".repeat(70));
        
        System.out.println("\nOriginal DateTime: " + dateTime);
        System.out.println();
        
        String[][] formats = {
            {"dd/MM/yyyy HH:mm:ss", "Date + 24hr Time"},
            {"dd/MM/yyyy hh:mm:ss a", "Date + 12hr Time + AM/PM"},
            {"yyyy-MM-dd'T'HH:mm:ss", "ISO DateTime"},
            {"EEE, dd MMM yyyy HH:mm", "Weekday + Date + Time"},
            {"EEEE, dd MMMM yyyy 'at' hh:mm a", "Full Format"},
            {"dd-MM-yyyy HH:mm:ss.SSS", "With Milliseconds"},
            {"MMM dd, yyyy h:mm a", "US Style"}
        };
        
        System.out.println("┌──────────────────────────────────┬────────────────────────────┐");
        System.out.println("│        Format Pattern            │          Result            │");
        System.out.println("├──────────────────────────────────┼────────────────────────────┤");
        
        for (String[] format : formats) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format[0]);
            String result = dateTime.format(formatter);
            System.out.printf("│ %-32s │ %-26s │%n", format[0], result);
        }
        
        System.out.println("└──────────────────────────────────┴────────────────────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display predefined format styles
     */
    public static void displayPredefinedStyles(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("PREDEFINED FORMAT STYLES");
        System.out.println("═".repeat(70));
        
        System.out.println("\nOriginal Date: " + date);
        System.out.println();
        
        System.out.println("┌─────────────────────┬─────────────────────────────────┐");
        System.out.println("│    Format Style     │             Result              │");
        System.out.println("├─────────────────────┼─────────────────────────────────┤");
        
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter longFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter fullFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        
        System.out.printf("│ SHORT               │ %-31s │%n", date.format(shortFormatter));
        System.out.printf("│ MEDIUM              │ %-31s │%n", date.format(mediumFormatter));
        System.out.printf("│ LONG                │ %-31s │%n", date.format(longFormatter));
        System.out.printf("│ FULL                │ %-31s │%n", date.format(fullFormatter));
        
        System.out.println("└─────────────────────┴─────────────────────────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display locale-specific formats
     */
    public static void displayLocaleFormats(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("LOCALE-SPECIFIC FORMATS");
        System.out.println("═".repeat(70));
        
        System.out.println("\nOriginal Date: " + date);
        System.out.println();
        
        Locale[] locales = {
            Locale.US,
            Locale.UK,
            Locale.FRANCE,
            Locale.GERMANY,
            Locale.JAPAN,
            Locale.CHINA,
            new Locale("hi", "IN") // Hindi, India
        };
        
        System.out.println("┌─────────────────────┬─────────────────────────────────┐");
        System.out.println("│       Locale        │             Format              │");
        System.out.println("├─────────────────────┼─────────────────────────────────┤");
        
        for (Locale locale : locales) {
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                                                          .withLocale(locale);
            String formatted = date.format(formatter);
            System.out.printf("│ %-19s │ %-31s │%n", 
                            locale.getDisplayCountry(Locale.ENGLISH), formatted);
        }
        
        System.out.println("└─────────────────────┴─────────────────────────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display custom creative formats
     */
    public static void displayCreativeFormats(LocalDate date) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("CREATIVE DATE FORMATS");
        System.out.println("═".repeat(70));
        
        System.out.println("\nOriginal Date: " + date);
        System.out.println();
        
        // Custom creative formats
        System.out.println("Creative Formats:");
        
        // Ordinal day
        int day = date.getDayOfMonth();
        String ordinal = getOrdinal(day);
        System.out.println("  Ordinal:    " + day + ordinal + " of " + 
                         date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + 
                         ", " + date.getYear());
        
        // Day of year
        System.out.println("  Day of Year: Day " + date.getDayOfYear() + " of " + date.getYear());
        
        // Week of year
        System.out.println("  Week Number: Week " + date.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear()) + 
                         " of " + date.getYear());
        
        // Quarter
        int quarter = (date.getMonthValue() - 1) / 3 + 1;
        System.out.println("  Quarter:     Q" + quarter + " " + date.getYear());
        
        // Relative format
        long daysFromNow = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), date);
        if (daysFromNow == 0) {
            System.out.println("  Relative:    Today");
        } else if (daysFromNow == 1) {
            System.out.println("  Relative:    Tomorrow");
        } else if (daysFromNow == -1) {
            System.out.println("  Relative:    Yesterday");
        } else if (daysFromNow > 0) {
            System.out.println("  Relative:    " + daysFromNow + " days from now");
        } else {
            System.out.println("  Relative:    " + Math.abs(daysFromNow) + " days ago");
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Helper method to get ordinal suffix
     */
    private static String getOrdinal(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }
    
    /**
     * Parse dates from various formats
     */
    public static void demonstrateParsing() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("PARSING DATES FROM DIFFERENT FORMATS");
        System.out.println("═".repeat(70));
        
        String[][] dateStrings = {
            {"15/03/2024", "dd/MM/yyyy"},
            {"2024-03-15", "yyyy-MM-dd"},
            {"15-Mar-2024", "dd-MMM-yyyy"},
            {"March 15, 2024", "MMMM dd, yyyy"},
            {"Fri, Mar 15, 2024", "EEE, MMM dd, yyyy"}
        };
        
        System.out.println("\n┌──────────────────────┬──────────────────┬─────────────┐");
        System.out.println("│    Date String       │  Format Pattern  │   Parsed    │");
        System.out.println("├──────────────────────┼──────────────────┼─────────────┤");
        
        for (String[] entry : dateStrings) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(entry[1]);
                LocalDate parsed = LocalDate.parse(entry[0], formatter);
                System.out.printf("│ %-20s │ %-16s │ %-11s │%n", 
                                entry[0], entry[1], parsed);
            } catch (Exception e) {
                System.out.printf("│ %-20s │ %-16s │ %-11s │%n", 
                                entry[0], entry[1], "ERROR");
            }
        }
        
        System.out.println("└──────────────────────┴──────────────────┴─────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(25) + "DATE FORMATTING" + " ".repeat(28) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        
        // Test Case 1: Three required formats
        System.out.println("\n--- Test Case 1: Three Required Formats ---");
        displayInThreeFormats(today);
        
        // Test Case 2: Various date formats
        System.out.println("\n\n--- Test Case 2: Various Date Formats ---");
        displayVariousFormats(today);
        
        // Test Case 3: Date and time formats
        System.out.println("\n\n--- Test Case 3: Date and Time Formats ---");
        displayDateTimeFormats(now);
        
        // Test Case 4: Predefined styles
        System.out.println("\n\n--- Test Case 4: Predefined Format Styles ---");
        displayPredefinedStyles(today);
        
        // Test Case 5: Locale-specific formats
        System.out.println("\n\n--- Test Case 5: Locale-Specific Formats ---");
        displayLocaleFormats(today);
        
        // Test Case 6: Creative formats
        System.out.println("\n\n--- Test Case 6: Creative Date Formats ---");
        displayCreativeFormats(today);
        
        // Test Case 7: Parsing demonstration
        System.out.println("\n\n--- Test Case 7: Parsing Dates ---");
        demonstrateParsing();
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.println("Options:");
        System.out.println("1. Format current date in three required formats");
        System.out.println("2. Format custom date in various formats");
        System.out.println("3. Format with custom pattern");
        System.out.println("4. Parse date from string");
        System.out.println("0. Exit");
        
        while (true) {
            System.out.print("\nEnter choice (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) break;
            
            try {
                switch (choice) {
                    case 1:
                        displayInThreeFormats(LocalDate.now());
                        break;
                        
                    case 2:
                        System.out.print("Enter date (dd/MM/yyyy) or press Enter for today: ");
                        String dateInput = scanner.nextLine();
                        LocalDate date = dateInput.isEmpty() ? 
                                        LocalDate.now() : 
                                        LocalDate.parse(dateInput, 
                                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        displayVariousFormats(date);
                        break;
                        
                    case 3:
                        System.out.print("Enter date (dd/MM/yyyy): ");
                        LocalDate customDate = LocalDate.parse(scanner.nextLine(), 
                                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Enter format pattern (e.g., dd-MMM-yyyy): ");
                        String pattern = scanner.nextLine();
                        
                        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(pattern);
                        System.out.println("\nFormatted: " + customDate.format(customFormatter));
                        break;
                        
                    case 4:
                        System.out.print("Enter date string: ");
                        String dateStr = scanner.nextLine();
                        System.out.print("Enter format pattern: ");
                        String formatPattern = scanner.nextLine();
                        
                        DateTimeFormatter parser = DateTimeFormatter.ofPattern(formatPattern);
                        LocalDate parsed = LocalDate.parse(dateStr, parser);
                        System.out.println("\nParsed date: " + parsed);
                        System.out.println("Standard format: " + parsed.format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        break;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("\nThank you for using Date Formatting!");
    }
}
