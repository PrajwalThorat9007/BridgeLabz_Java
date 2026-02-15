package collection.implementation;

/*
 * Question 1: Insurance Policy Management System
 *
 * Each policy has the following attributes:
 * - Policy Number (unique identifier)
 * - Policyholder Name
 * - Expiry Date
 * - Coverage Type (e.g., Health, Auto, Home)
 * - Premium Amount
 *
 * Requirements:
 * 1. Store Unique Policies: Implement methods to store policies using different types of sets
 *    (HashSet, LinkedHashSet, TreeSet)
 * 2. Retrieve Policies: Implement methods to retrieve and display policies based on criteria
 * 3. Performance Comparison: Compare performance of different set implementations
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class InsurancePolicyManagement {

    // Policy class representing an insurance policy
    static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                      String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
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

        // Compare policies by expiry date for TreeSet sorting
        @Override
        public int compareTo(Policy other) {
            return this.expiryDate.compareTo(other.expiryDate);
        }

        // Equals and hashCode based on policy number (unique identifier)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy policy = (Policy) obj;
            return policyNumber.equals(policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }

        @Override
        public String toString() {
            return String.format("Policy[%s, %s, Exp: %s, %s, $%.2f]",
                    policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
        }
    }

    // Policy Management System class
    static class PolicyManager {
        private Set<Policy> hashSetPolicies;
        private Set<Policy> linkedHashSetPolicies;
        private Set<Policy> treeSetPolicies;

        public PolicyManager() {
            hashSetPolicies = new HashSet<>();
            linkedHashSetPolicies = new LinkedHashSet<>();
            treeSetPolicies = new TreeSet<>();
        }

        // Add policy to all sets
        public void addPolicy(Policy policy) {
            hashSetPolicies.add(policy);
            linkedHashSetPolicies.add(policy);
            treeSetPolicies.add(policy);
        }

        // Add policy to specific set type
        public boolean addToHashSet(Policy policy) {
            return hashSetPolicies.add(policy);
        }

        public boolean addToLinkedHashSet(Policy policy) {
            return linkedHashSetPolicies.add(policy);
        }

        public boolean addToTreeSet(Policy policy) {
            return treeSetPolicies.add(policy);
        }

        // Remove policy from all sets
        public void removePolicy(String policyNumber) {
            Policy toRemove = findPolicyByNumber(policyNumber);
            if (toRemove != null) {
                hashSetPolicies.remove(toRemove);
                linkedHashSetPolicies.remove(toRemove);
                treeSetPolicies.remove(toRemove);
            }
        }

        // Find policy by number
        public Policy findPolicyByNumber(String policyNumber) {
            for (Policy policy : hashSetPolicies) {
                if (policy.getPolicyNumber().equals(policyNumber)) {
                    return policy;
                }
            }
            return null;
        }

        // Get all unique policies from HashSet
        public Set<Policy> getAllUniquePolicies() {
            return new HashSet<>(hashSetPolicies);
        }

        // Get policies expiring soon (within 30 days)
        public List<Policy> getPoliciesExpiringSoon() {
            List<Policy> expiringSoon = new ArrayList<>();
            LocalDate today = LocalDate.now();
            LocalDate thirtyDaysLater = today.plusDays(30);

            for (Policy policy : hashSetPolicies) {
                LocalDate expiryDate = policy.getExpiryDate();
                if (!expiryDate.isBefore(today) && !expiryDate.isAfter(thirtyDaysLater)) {
                    expiringSoon.add(policy);
                }
            }

            return expiringSoon;
        }

        // Get policies by coverage type
        public List<Policy> getPoliciesByCoverageType(String coverageType) {
            List<Policy> policies = new ArrayList<>();

            for (Policy policy : hashSetPolicies) {
                if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                    policies.add(policy);
                }
            }

            return policies;
        }

        // Find duplicate policies (same policy number added multiple times)
        public List<String> findDuplicatePolicyNumbers(List<Policy> policyList) {
            Set<String> seen = new HashSet<>();
            List<String> duplicates = new ArrayList<>();

            for (Policy policy : policyList) {
                if (!seen.add(policy.getPolicyNumber())) {
                    if (!duplicates.contains(policy.getPolicyNumber())) {
                        duplicates.add(policy.getPolicyNumber());
                    }
                }
            }

            return duplicates;
        }

        // Display policies from HashSet (unordered)
        public void displayHashSetPolicies() {
            System.out.println("=== HashSet Policies (Unordered) ===");
            for (Policy policy : hashSetPolicies) {
                System.out.println(policy);
            }
        }

        // Display policies from LinkedHashSet (insertion order)
        public void displayLinkedHashSetPolicies() {
            System.out.println("=== LinkedHashSet Policies (Insertion Order) ===");
            for (Policy policy : linkedHashSetPolicies) {
                System.out.println(policy);
            }
        }

        // Display policies from TreeSet (sorted by expiry date)
        public void displayTreeSetPolicies() {
            System.out.println("=== TreeSet Policies (Sorted by Expiry Date) ===");
            for (Policy policy : treeSetPolicies) {
                System.out.println(policy);
            }
        }

        // Performance comparison method
        public void performanceComparison(int numberOfPolicies) {
            System.out.println("\n=== Performance Comparison ===");
            System.out.println("Testing with " + numberOfPolicies + " policies\n");

            List<Policy> testPolicies = generateTestPolicies(numberOfPolicies);

            // Test HashSet
            long startTime = System.nanoTime();
            Set<Policy> testHashSet = new HashSet<>();
            for (Policy p : testPolicies) {
                testHashSet.add(p);
            }
            long hashSetAddTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            Policy searchPolicy = testPolicies.get(numberOfPolicies / 2);
            testHashSet.contains(searchPolicy);
            long hashSetSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            testHashSet.remove(searchPolicy);
            long hashSetRemoveTime = System.nanoTime() - startTime;

            // Test LinkedHashSet
            startTime = System.nanoTime();
            Set<Policy> testLinkedHashSet = new LinkedHashSet<>();
            for (Policy p : testPolicies) {
                testLinkedHashSet.add(p);
            }
            long linkedHashSetAddTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            testLinkedHashSet.contains(searchPolicy);
            long linkedHashSetSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            testLinkedHashSet.remove(searchPolicy);
            long linkedHashSetRemoveTime = System.nanoTime() - startTime;

            // Test TreeSet
            startTime = System.nanoTime();
            Set<Policy> testTreeSet = new TreeSet<>();
            for (Policy p : testPolicies) {
                testTreeSet.add(p);
            }
            long treeSetAddTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            testTreeSet.contains(searchPolicy);
            long treeSetSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            testTreeSet.remove(searchPolicy);
            long treeSetRemoveTime = System.nanoTime() - startTime;

            // Display results
            System.out.printf("%-20s %-15s %-15s %-15s%n", "Set Type", "Add Time (ns)", "Search Time (ns)", "Remove Time (ns)");
            System.out.println("=".repeat(65));
            System.out.printf("%-20s %-15d %-15d %-15d%n", "HashSet", hashSetAddTime, hashSetSearchTime, hashSetRemoveTime);
            System.out.printf("%-20s %-15d %-15d %-15d%n", "LinkedHashSet", linkedHashSetAddTime, linkedHashSetSearchTime, linkedHashSetRemoveTime);
            System.out.printf("%-20s %-15d %-15d %-15d%n", "TreeSet", treeSetAddTime, treeSetSearchTime, treeSetRemoveTime);
        }

        // Generate test policies for performance testing
        private List<Policy> generateTestPolicies(int count) {
            List<Policy> policies = new ArrayList<>();
            String[] coverageTypes = {"Health", "Auto", "Home", "Life"};

            for (int i = 0; i < count; i++) {
                Policy policy = new Policy(
                        "POL" + String.format("%05d", i),
                        "Holder" + i,
                        LocalDate.now().plusDays(i % 365),
                        coverageTypes[i % coverageTypes.length],
                        1000 + (i * 10)
                );
                policies.add(policy);
            }

            return policies;
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        System.out.println("=== Insurance Policy Management System ===\n");

        // Add sample policies
        manager.addPolicy(new Policy("POL001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.00));
        manager.addPolicy(new Policy("POL002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800.00));
        manager.addPolicy(new Policy("POL003", "Bob Johnson", LocalDate.now().plusDays(5), "Home", 1500.00));
        manager.addPolicy(new Policy("POL004", "Alice Brown", LocalDate.now().plusDays(90), "Health", 1100.00));
        manager.addPolicy(new Policy("POL005", "Charlie Davis", LocalDate.now().plusDays(20), "Auto", 900.00));
        manager.addPolicy(new Policy("POL006", "Diana Wilson", LocalDate.now().plusDays(120), "Life", 2000.00));

        // Display policies in different sets
        manager.displayHashSetPolicies();
        System.out.println();

        manager.displayLinkedHashSetPolicies();
        System.out.println();

        manager.displayTreeSetPolicies();
        System.out.println();

        // Retrieve policies expiring soon
        System.out.println("=== Policies Expiring Soon (Within 30 Days) ===");
        List<Policy> expiringSoon = manager.getPoliciesExpiringSoon();
        for (Policy policy : expiringSoon) {
            long daysUntilExpiry = ChronoUnit.DAYS.between(LocalDate.now(), policy.getExpiryDate());
            System.out.println(policy + " - Expires in " + daysUntilExpiry + " days");
        }
        System.out.println();

        // Retrieve policies by coverage type
        System.out.println("=== Health Insurance Policies ===");
        List<Policy> healthPolicies = manager.getPoliciesByCoverageType("Health");
        for (Policy policy : healthPolicies) {
            System.out.println(policy);
        }
        System.out.println();

        // Test duplicate detection
        System.out.println("=== Testing Duplicate Policy Detection ===");
        List<Policy> testList = new ArrayList<>();
        testList.add(new Policy("POL001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.00));
        testList.add(new Policy("POL002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800.00));
        testList.add(new Policy("POL001", "John Doe Duplicate", LocalDate.now().plusDays(20), "Health", 1300.00));
        testList.add(new Policy("POL003", "Bob Johnson", LocalDate.now().plusDays(5), "Home", 1500.00));

        List<String> duplicates = manager.findDuplicatePolicyNumbers(testList);
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate policy numbers found.");
        } else {
            System.out.println("Duplicate policy numbers: " + duplicates);
        }
        System.out.println();

        // Performance comparison
        manager.performanceComparison(1000);

        System.out.println("\n=== Summary ===");
        System.out.println("HashSet: Best for quick lookups, no order guarantee");
        System.out.println("LinkedHashSet: Maintains insertion order, slightly slower than HashSet");
        System.out.println("TreeSet: Maintains sorted order (by expiry date), slowest for add/remove");
    }
}