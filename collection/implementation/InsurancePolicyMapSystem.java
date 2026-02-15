package collection.implementation;

/*
 * Question 2: Insurance Policy Management System (Map-based)
 *
 * Build a system for managing insurance policies where you have to:
 * - Store and manage policies with unique identifiers
 * - Retrieve and manipulate policies based on different criteria
 * - Track policies by various attributes such as policyholder name and expiry date
 *
 * Requirements:
 * 1. Store Policies in a Map:
 *    - Use HashMap to store policies with policy numbers as keys
 *    - Use LinkedHashMap to maintain insertion order
 *    - Use TreeMap to store policies sorted by expiry date
 *
 * 2. Retrieve and Manipulate Policies:
 *    - Retrieve a policy by its number
 *    - List all policies expiring within the next 30 days
 *    - List all policies for a specific policyholder
 *    - Remove policies that are expired
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class InsurancePolicyMapSystem {

    // Policy class representing an insurance policy
    static class Policy {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;
        private LocalDate issueDate;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                      String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
            this.issueDate = LocalDate.now();
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getPolicyholderName() {
            return policyholderName;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        public LocalDate getIssueDate() {
            return issueDate;
        }

        public boolean isExpired() {
            return LocalDate.now().isAfter(expiryDate);
        }

        public long getDaysUntilExpiry() {
            return ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            return String.format("Policy[%s, %s, Type: %s, Premium: $%.2f, Expires: %s]",
                    policyNumber, policyholderName, coverageType, premiumAmount,
                    expiryDate.format(formatter));
        }
    }

    // Comparator for sorting policies by expiry date
    static class ExpiryDateComparator implements Comparator<String> {
        private Map<String, Policy> policyMap;

        public ExpiryDateComparator(Map<String, Policy> policyMap) {
            this.policyMap = policyMap;
        }

        @Override
        public int compare(String policyNum1, String policyNum2) {
            Policy p1 = policyMap.get(policyNum1);
            Policy p2 = policyMap.get(policyNum2);

            int dateCompare = p1.getExpiryDate().compareTo(p2.getExpiryDate());

            // If expiry dates are equal, compare by policy number for consistency
            if (dateCompare == 0) {
                return policyNum1.compareTo(policyNum2);
            }

            return dateCompare;
        }
    }

    // Policy Management System class
    static class PolicyMapManager {
        private Map<String, Policy> hashMapPolicies;
        private Map<String, Policy> linkedHashMapPolicies;
        private TreeMap<String, Policy> treeMapPolicies;

        public PolicyMapManager() {
            hashMapPolicies = new HashMap<>();
            linkedHashMapPolicies = new LinkedHashMap<>();

            // TreeMap with custom comparator for sorting by expiry date
            Map<String, Policy> tempMap = new HashMap<>();
            treeMapPolicies = new TreeMap<>(new ExpiryDateComparator(tempMap));
        }

        // Add policy to all maps
        public void addPolicy(Policy policy) {
            String policyNumber = policy.getPolicyNumber();
            hashMapPolicies.put(policyNumber, policy);
            linkedHashMapPolicies.put(policyNumber, policy);
            treeMapPolicies.put(policyNumber, policy);

            System.out.println("Added: " + policy);
        }

        // Add policy to specific map
        public void addToHashMap(String policyNumber, Policy policy) {
            hashMapPolicies.put(policyNumber, policy);
        }

        public void addToLinkedHashMap(String policyNumber, Policy policy) {
            linkedHashMapPolicies.put(policyNumber, policy);
        }

        public void addToTreeMap(String policyNumber, Policy policy) {
            treeMapPolicies.put(policyNumber, policy);
        }

        // Retrieve policy by policy number from HashMap
        public Policy retrievePolicyByNumber(String policyNumber) {
            return hashMapPolicies.get(policyNumber);
        }

        // List all policies expiring within next 30 days
        public List<Policy> getPoliciesExpiringIn30Days() {
            List<Policy> expiringSoon = new ArrayList<>();
            LocalDate today = LocalDate.now();
            LocalDate thirtyDaysLater = today.plusDays(30);

            for (Policy policy : hashMapPolicies.values()) {
                LocalDate expiryDate = policy.getExpiryDate();

                // Check if expiry is between today and 30 days from now
                if (!expiryDate.isBefore(today) && !expiryDate.isAfter(thirtyDaysLater)) {
                    expiringSoon.add(policy);
                }
            }

            // Sort by expiry date
            expiringSoon.sort(Comparator.comparing(Policy::getExpiryDate));

            return expiringSoon;
        }

        // List all policies for a specific policyholder
        public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
            List<Policy> holderPolicies = new ArrayList<>();

            for (Policy policy : hashMapPolicies.values()) {
                if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                    holderPolicies.add(policy);
                }
            }

            return holderPolicies;
        }

        // Remove expired policies from all maps
        public int removeExpiredPolicies() {
            int removedCount = 0;
            List<String> expiredPolicyNumbers = new ArrayList<>();

            // Find expired policies
            for (Map.Entry<String, Policy> entry : hashMapPolicies.entrySet()) {
                if (entry.getValue().isExpired()) {
                    expiredPolicyNumbers.add(entry.getKey());
                }
            }

            // Remove from all maps
            for (String policyNumber : expiredPolicyNumbers) {
                Policy removed = hashMapPolicies.remove(policyNumber);
                linkedHashMapPolicies.remove(policyNumber);
                treeMapPolicies.remove(policyNumber);

                if (removed != null) {
                    System.out.println("Removed expired policy: " + removed);
                    removedCount++;
                }
            }

            return removedCount;
        }

        // Remove specific policy by number
        public boolean removePolicy(String policyNumber) {
            Policy removed = hashMapPolicies.remove(policyNumber);
            linkedHashMapPolicies.remove(policyNumber);
            treeMapPolicies.remove(policyNumber);

            if (removed != null) {
                System.out.println("Removed policy: " + removed);
                return true;
            }

            return false;
        }

        // Update policy premium
        public boolean updatePolicyPremium(String policyNumber, double newPremium) {
            Policy policy = hashMapPolicies.get(policyNumber);

            if (policy != null) {
                // Create new policy with updated premium
                Policy updatedPolicy = new Policy(
                        policy.getPolicyNumber(),
                        policy.getPolicyholderName(),
                        policy.getExpiryDate(),
                        policy.getCoverageType(),
                        newPremium
                );

                // Update in all maps
                hashMapPolicies.put(policyNumber, updatedPolicy);
                linkedHashMapPolicies.put(policyNumber, updatedPolicy);
                treeMapPolicies.put(policyNumber, updatedPolicy);

                return true;
            }

            return false;
        }

        // Get all policies from HashMap
        public Collection<Policy> getAllPolicies() {
            return hashMapPolicies.values();
        }

        // Get policy count
        public int getPolicyCount() {
            return hashMapPolicies.size();
        }

        // Display policies from HashMap
        public void displayHashMapPolicies() {
            System.out.println("=== HashMap Policies (Unordered) ===");
            for (Map.Entry<String, Policy> entry : hashMapPolicies.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        // Display policies from LinkedHashMap (insertion order)
        public void displayLinkedHashMapPolicies() {
            System.out.println("=== LinkedHashMap Policies (Insertion Order) ===");
            for (Map.Entry<String, Policy> entry : linkedHashMapPolicies.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        // Display policies from TreeMap (sorted by expiry date)
        public void displayTreeMapPolicies() {
            System.out.println("=== TreeMap Policies (Sorted by Expiry Date) ===");
            for (Map.Entry<String, Policy> entry : treeMapPolicies.entrySet()) {
                Policy policy = entry.getValue();
                long daysUntilExpiry = policy.getDaysUntilExpiry();
                System.out.println(entry.getKey() + " -> " + entry.getValue() +
                        " (in " + daysUntilExpiry + " days)");
            }
        }

        // Get statistics
        public void displayStatistics() {
            System.out.println("=== Policy Statistics ===");
            System.out.println("Total Policies: " + getPolicyCount());

            // Count by coverage type
            Map<String, Integer> coverageCount = new HashMap<>();
            double totalPremiums = 0;

            for (Policy policy : hashMapPolicies.values()) {
                String coverage = policy.getCoverageType();
                coverageCount.put(coverage, coverageCount.getOrDefault(coverage, 0) + 1);
                totalPremiums += policy.getPremiumAmount();
            }

            System.out.println("\nPolicies by Coverage Type:");
            for (Map.Entry<String, Integer> entry : coverageCount.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }

            System.out.printf("\nTotal Premium Value: $%.2f%n", totalPremiums);
            System.out.printf("Average Premium: $%.2f%n", totalPremiums / getPolicyCount());
        }

        // Search policies by coverage type
        public List<Policy> searchByCoverageType(String coverageType) {
            List<Policy> result = new ArrayList<>();

            for (Policy policy : hashMapPolicies.values()) {
                if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                    result.add(policy);
                }
            }

            return result;
        }

        // Get policies in premium range
        public List<Policy> getPoliciesInPremiumRange(double minPremium, double maxPremium) {
            List<Policy> result = new ArrayList<>();

            for (Policy policy : hashMapPolicies.values()) {
                double premium = policy.getPremiumAmount();
                if (premium >= minPremium && premium <= maxPremium) {
                    result.add(policy);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        PolicyMapManager manager = new PolicyMapManager();

        System.out.println("=== Insurance Policy Management System (Map-based) ===\n");

        // Add sample policies
        System.out.println("--- Adding Policies ---");
        manager.addPolicy(new Policy("POL001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.00));
        manager.addPolicy(new Policy("POL002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800.00));
        manager.addPolicy(new Policy("POL003", "Bob Johnson", LocalDate.now().plusDays(5), "Home", 1500.00));
        manager.addPolicy(new Policy("POL004", "Alice Brown", LocalDate.now().plusDays(90), "Health", 1100.00));
        manager.addPolicy(new Policy("POL005", "Charlie Davis", LocalDate.now().plusDays(20), "Auto", 900.00));
        manager.addPolicy(new Policy("POL006", "John Doe", LocalDate.now().plusDays(120), "Life", 2000.00));
        manager.addPolicy(new Policy("POL007", "Diana Wilson", LocalDate.now().plusDays(10), "Health", 1300.00));
        manager.addPolicy(new Policy("POL008", "Eve Martinez", LocalDate.now().minusDays(5), "Auto", 850.00)); // Expired

        System.out.println();

        // Display policies in different maps
        manager.displayHashMapPolicies();
        System.out.println();

        manager.displayLinkedHashMapPolicies();
        System.out.println();

        manager.displayTreeMapPolicies();
        System.out.println();

        // Retrieve policy by number
        System.out.println("--- Retrieve Policy by Number ---");
        String searchNumber = "POL003";
        Policy found = manager.retrievePolicyByNumber(searchNumber);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Policy " + searchNumber + " not found.");
        }
        System.out.println();

        // List policies expiring within 30 days
        System.out.println("--- Policies Expiring Within 30 Days ---");
        List<Policy> expiringSoon = manager.getPoliciesExpiringIn30Days();
        if (expiringSoon.isEmpty()) {
            System.out.println("No policies expiring in the next 30 days.");
        } else {
            for (Policy policy : expiringSoon) {
                System.out.println(policy + " - " + policy.getDaysUntilExpiry() + " days remaining");
            }
        }
        System.out.println();

        // List policies for specific policyholder
        System.out.println("--- Policies for John Doe ---");
        List<Policy> johnsPolicies = manager.getPoliciesByPolicyholder("John Doe");
        if (johnsPolicies.isEmpty()) {
            System.out.println("No policies found for John Doe.");
        } else {
            for (Policy policy : johnsPolicies) {
                System.out.println(policy);
            }
        }
        System.out.println();

        // Remove expired policies
        System.out.println("--- Removing Expired Policies ---");
        int removedCount = manager.removeExpiredPolicies();
        System.out.println("Total expired policies removed: " + removedCount);
        System.out.println();

        // Display statistics
        manager.displayStatistics();
        System.out.println();

        // Search by coverage type
        System.out.println("--- Health Insurance Policies ---");
        List<Policy> healthPolicies = manager.searchByCoverageType("Health");
        for (Policy policy : healthPolicies) {
            System.out.println(policy);
        }
        System.out.println();

        // Get policies in premium range
        System.out.println("--- Policies with Premium $1000-$1500 ---");
        List<Policy> premiumRange = manager.getPoliciesInPremiumRange(1000, 1500);
        for (Policy policy : premiumRange) {
            System.out.println(policy);
        }
        System.out.println();

        // Final count
        System.out.println("--- Final Summary ---");
        System.out.println("Total active policies: " + manager.getPolicyCount());
    }
}