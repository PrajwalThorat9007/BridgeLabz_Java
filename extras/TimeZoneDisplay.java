package extras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Problem 1: Time Zones and ZonedDateTime
 * Display the current time in different time zones: GMT, IST, and PST
 */
public class TimeZoneDisplay {
    
    /**
     * Get current time in specified time zone
     */
    public static ZonedDateTime getCurrentTimeInZone(String zoneId) {
        return ZonedDateTime.now(ZoneId.of(zoneId));
    }
    
    /**
     * Display time in multiple time zones
     */
    public static void displayMultipleTimeZones() {
        // Define time zones
        String[] zoneIds = {
            "GMT",           // Greenwich Mean Time
            "Asia/Kolkata",  // Indian Standard Time
            "America/Los_Angeles"  // Pacific Standard Time
        };
        
        String[] zoneNames = {
            "GMT (Greenwich Mean Time)",
            "IST (Indian Standard Time)",
            "PST (Pacific Standard Time)"
        };
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("CURRENT TIME IN DIFFERENT TIME ZONES");
        System.out.println("═".repeat(70));
        System.out.println();
        
        for (int i = 0; i < zoneIds.length; i++) {
            ZonedDateTime zonedDateTime = getCurrentTimeInZone(zoneIds[i]);
            System.out.printf("%-35s : %s%n", 
                            zoneNames[i], 
                            zonedDateTime.format(formatter));
        }
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display detailed time zone information
     */
    public static void displayDetailedTimeZoneInfo(String zoneId, String zoneName) {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(zoneId));
        ZoneId zone = ZoneId.of(zoneId);
        
        System.out.println("\n┌" + "─".repeat(68) + "┐");
        System.out.println("│  " + zoneName + " ".repeat(66 - zoneName.length()) + "│");
        System.out.println("├" + "─".repeat(68) + "┤");
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        
        System.out.printf("│  Zone ID:           %-47s │%n", zone.getId());
        System.out.printf("│  Date:              %-47s │%n", zdt.format(dateFormatter));
        System.out.printf("│  Time:              %-47s │%n", zdt.format(timeFormatter));
        System.out.printf("│  Time Zone:         %-47s │%n", zdt.getZone());
        System.out.printf("│  Offset:            %-47s │%n", zdt.getOffset());
        System.out.printf("│  Day of Week:       %-47s │%n", zdt.getDayOfWeek());
        System.out.printf("│  Day of Year:       %-47d │%n", zdt.getDayOfYear());
        System.out.printf("│  ISO Format:        %-47s │%n", zdt.format(fullFormatter));
        
        System.out.println("└" + "─".repeat(68) + "┘");
    }
    
    /**
     * Compare time differences between zones
     */
    public static void compareTimeZones() {
        ZonedDateTime gmt = getCurrentTimeInZone("GMT");
        ZonedDateTime ist = getCurrentTimeInZone("Asia/Kolkata");
        ZonedDateTime pst = getCurrentTimeInZone("America/Los_Angeles");
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("TIME ZONE COMPARISON");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        System.out.println("\nCurrent Times:");
        System.out.println("  GMT: " + gmt.format(formatter));
        System.out.println("  IST: " + ist.format(formatter));
        System.out.println("  PST: " + pst.format(formatter));
        
        System.out.println("\nTime Differences:");
        long istGmtDiff = Duration.between(gmt, ist).toHours();
        long pstGmtDiff = Duration.between(gmt, pst).toHours();
        long istPstDiff = Duration.between(pst, ist).toHours();
        
        System.out.println("  IST is " + istGmtDiff + " hours ahead of GMT");
        System.out.println("  PST is " + Math.abs(pstGmtDiff) + " hours behind GMT");
        System.out.println("  IST is " + istPstDiff + " hours ahead of PST");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Convert time from one zone to another
     */
    public static ZonedDateTime convertTimeZone(ZonedDateTime sourceTime, String targetZoneId) {
        return sourceTime.withZoneSameInstant(ZoneId.of(targetZoneId));
    }
    
    /**
     * Display world clock
     */
    public static void displayWorldClock() {
        String[] cities = {
            "GMT", "Europe/London", "London",
            "Asia/Kolkata", "Asia/Kolkata", "Mumbai",
            "America/Los_Angeles", "America/Los_Angeles", "Los Angeles",
            "America/New_York", "America/New_York", "New York",
            "Asia/Tokyo", "Asia/Tokyo", "Tokyo",
            "Australia/Sydney", "Australia/Sydney", "Sydney",
            "Europe/Paris", "Europe/Paris", "Paris",
            "Asia/Dubai", "Asia/Dubai", "Dubai"
        };
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("WORLD CLOCK");
        System.out.println("═".repeat(70));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        System.out.println("┌────────────────────┬─────────────────┬──────────────┐");
        System.out.println("│       City         │    Time Zone    │     Time     │");
        System.out.println("├────────────────────┼─────────────────┼──────────────┤");
        
        for (int i = 0; i < cities.length; i += 3) {
            String zoneId = cities[i + 1];
            String cityName = cities[i + 2];
            ZonedDateTime time = getCurrentTimeInZone(zoneId);
            
            System.out.printf("│ %-18s │ %-15s │ %-12s │%n",
                            cityName,
                            time.getZone(),
                            time.format(formatter));
        }
        
        System.out.println("└────────────────────┴─────────────────┴──────────────┘");
    }
    
    /**
     * Display all available time zones
     */
    public static void displayAvailableZones() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("AVAILABLE TIME ZONES (Sample)");
        System.out.println("═".repeat(70));
        
        Set<String> zones = ZoneId.getAvailableZoneIds();
        List<String> sortedZones = new ArrayList<>(zones);
        Collections.sort(sortedZones);
        
        int count = 0;
        for (String zone : sortedZones) {
            System.out.printf("%-35s", zone);
            count++;
            if (count % 2 == 0) {
                System.out.println();
            }
            if (count >= 20) break; // Show only first 20
        }
        
        System.out.println("\n\nTotal available zones: " + zones.size());
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(20) + "TIME ZONES AND ZONED DATE TIME" + " ".repeat(18) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        // Test Case 1: Display current time in GMT, IST, PST
        System.out.println("\n--- Test Case 1: Current Time in Different Time Zones ---");
        displayMultipleTimeZones();
        
        // Test Case 2: Detailed information for each zone
        System.out.println("\n\n--- Test Case 2: Detailed Time Zone Information ---");
        displayDetailedTimeZoneInfo("GMT", "GMT (Greenwich Mean Time)");
        displayDetailedTimeZoneInfo("Asia/Kolkata", "IST (Indian Standard Time)");
        displayDetailedTimeZoneInfo("America/Los_Angeles", "PST (Pacific Standard Time)");
        
        // Test Case 3: Compare time zones
        System.out.println("\n\n--- Test Case 3: Time Zone Comparison ---");
        compareTimeZones();
        
        // Test Case 4: Convert between time zones
        System.out.println("\n\n--- Test Case 4: Time Zone Conversion ---");
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        
        System.out.println("Original (IST): " + istTime.format(formatter));
        System.out.println("Converted to GMT: " + convertTimeZone(istTime, "GMT").format(formatter));
        System.out.println("Converted to PST: " + convertTimeZone(istTime, "America/Los_Angeles").format(formatter));
        
        // Test Case 5: World clock
        System.out.println("\n\n--- Test Case 5: World Clock ---");
        displayWorldClock();
        
        // Test Case 6: Available zones
        System.out.println("\n\n--- Test Case 6: Available Time Zones ---");
        displayAvailableZones();
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.println("Options:");
        System.out.println("1. Display current time in GMT, IST, PST");
        System.out.println("2. Convert time between zones");
        System.out.println("3. Display world clock");
        System.out.println("4. Search for a time zone");
        System.out.println("0. Exit");
        
        while (true) {
            System.out.print("\nEnter choice (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) break;
            
            switch (choice) {
                case 1:
                    displayMultipleTimeZones();
                    break;
                    
                case 2:
                    System.out.print("Enter source zone (e.g., Asia/Kolkata): ");
                    String sourceZone = scanner.nextLine();
                    System.out.print("Enter target zone (e.g., GMT): ");
                    String targetZone = scanner.nextLine();
                    
                    try {
                        ZonedDateTime source = ZonedDateTime.now(ZoneId.of(sourceZone));
                        ZonedDateTime target = convertTimeZone(source, targetZone);
                        
                        System.out.println("\nSource: " + source.format(formatter));
                        System.out.println("Target: " + target.format(formatter));
                    } catch (Exception e) {
                        System.out.println("Invalid zone ID: " + e.getMessage());
                    }
                    break;
                    
                case 3:
                    displayWorldClock();
                    break;
                    
                case 4:
                    System.out.print("Enter zone name to search (e.g., America): ");
                    String search = scanner.nextLine();
                    
                    Set<String> zones = ZoneId.getAvailableZoneIds();
                    System.out.println("\nMatching zones:");
                    zones.stream()
                         .filter(z -> z.toLowerCase().contains(search.toLowerCase()))
                         .sorted()
                         .limit(10)
                         .forEach(System.out::println);
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
        System.out.println("\nThank you for using Time Zone Display!");
    }
}
