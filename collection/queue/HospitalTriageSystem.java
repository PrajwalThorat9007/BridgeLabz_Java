package collection.queue;

/*
 * Question 3: Hospital Triage System
 * Simulate a hospital triage system using a PriorityQueue where patients with higher severity are treated first.
 * Example: Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] → Order: Alice, John, Bob
 */

import java.util.PriorityQueue;

public class HospitalTriageSystem {
    
    // Patient class to store name and severity
    static class Patient implements Comparable<Patient> {
        String name;
        int severity;
        
        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
        
        // Compare based on severity (higher severity = higher priority)
        @Override
        public int compareTo(Patient other) {
            return other.severity - this.severity; // Descending order
        }
        
        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }
    
    // Add patient to triage system
    public static void addPatient(PriorityQueue<Patient> triageQueue, String name, int severity) {
        Patient patient = new Patient(name, severity);
        triageQueue.add(patient);
        System.out.println("Added patient: " + patient);
    }
    
    // Treat next patient (highest severity)
    public static void treatNextPatient(PriorityQueue<Patient> triageQueue) {
        if (triageQueue.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }
        
        Patient patient = triageQueue.poll();
        System.out.println("Treating patient: " + patient);
    }
    
    // Display all patients in order of treatment
    public static void displayPatientOrder(PriorityQueue<Patient> triageQueue) {
        System.out.println("\nPatients in treatment order:");
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(triageQueue);
        
        int order = 1;
        while (!tempQueue.isEmpty()) {
            Patient patient = tempQueue.poll();
            System.out.println(order + ". " + patient);
            order++;
        }
    }
    
    public static void main(String[] args) {
        // Create triage system
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
        
        System.out.println("=== Hospital Triage System ===\n");
        
        // Add patients with different severity levels
        addPatient(triageQueue, "John", 3);
        addPatient(triageQueue, "Alice", 5);
        addPatient(triageQueue, "Bob", 2);
        addPatient(triageQueue, "Charlie", 4);
        addPatient(triageQueue, "Diana", 1);
        
        // Display treatment order
        displayPatientOrder(triageQueue);
        
        System.out.println("\n=== Starting Treatment ===\n");
        
        // Treat patients in priority order
        while (!triageQueue.isEmpty()) {
            treatNextPatient(triageQueue);
        }
        
        System.out.println("\n=== Emergency Case ===\n");
        
        // Simulate new scenario
        PriorityQueue<Patient> emergencyQueue = new PriorityQueue<>();
        addPatient(emergencyQueue, "Emma", 2);
        addPatient(emergencyQueue, "Frank", 5);
        addPatient(emergencyQueue, "Grace", 3);
        
        System.out.println("\nNext patient to treat: " + emergencyQueue.peek());
        treatNextPatient(emergencyQueue);
        
        System.out.println("Remaining patients: " + emergencyQueue.size());
    }
}
