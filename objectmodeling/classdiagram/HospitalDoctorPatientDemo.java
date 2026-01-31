/*
Problem 3: Hospital, Doctors, and Patients (Association and Communication)
Description: Model a Hospital where Doctor and Patient objects interact through consultations. A doctor can see multiple patients, and each patient can consult multiple doctors.
Tasks:
Define a Hospital class containing Doctor and Patient classes.
Create a method consult() in the Doctor class to show communication, which would display the consultation between a doctor and a patient.
Model an association between doctors and patients to show that doctors and patients can have multiple relationships.
Goal: Practice creating an association with communication between objects by modeling doctor-patient consultations.
 */
import java.util.ArrayList;

// Patient class
class Patient {
    private String name; // patient name

    public Patient(String name) {
        this.name = name; // initializing patient name
    }

    public String getName() {
        return name; // returning patient name
    }
}

// Doctor class
class Doctor {
    private String name; // doctor name
    private ArrayList<Patient> patients; // associated patients

    public Doctor(String name) {
        this.name = name; // initializing doctor name
        this.patients = new ArrayList<>(); // initializing patient list
    }

    // communication between doctor and patient
    public void consult(Patient patient) {
        patients.add(patient); // associating patient with doctor
        System.out.println("Doctor " + name + " is consulting Patient " + patient.getName());
    }

    public String getName() {
        return name; // returning doctor name
    }
}

// Hospital class
class Hospital {
    private String hospitalName; // hospital name
    private ArrayList<Doctor> doctors; // doctors in hospital
    private ArrayList<Patient> patients; // patients in hospital

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName; // initializing hospital name
        this.doctors = new ArrayList<>(); // initializing doctors list
        this.patients = new ArrayList<>(); // initializing patients list
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor); // adding doctor
    }

    public void addPatient(Patient patient) {
        patients.add(patient); // adding patient
    }

    public void displayHospital() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("  " + p.getName());
        }
    }
}

// Main class
public class HospitalDoctorPatientDemo {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital"); // creating hospital

        Doctor d1 = new Doctor("Dr. Rao"); // creating doctor
        Doctor d2 = new Doctor("Dr. Sen"); // creating doctor

        Patient p1 = new Patient("Amit"); // creating patient
        Patient p2 = new Patient("Neha"); // creating patient

        hospital.addDoctor(d1); // adding doctor to hospital
        hospital.addDoctor(d2);

        hospital.addPatient(p1); // adding patient to hospital
        hospital.addPatient(p2);

        hospital.displayHospital(); // displaying hospital data

        d1.consult(p1); // doctor-patient communication
        d1.consult(p2);
        d2.consult(p1);
    }
}
