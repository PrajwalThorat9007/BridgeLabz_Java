package generics;
/*
AI-Driven Resume Screening System
Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards

Problem Statement:
Develop an AI-Driven Resume Screening System that can process resumes
for different job roles like Software Engineer, Data Scientist, and
Product Manager while ensuring type safety.
*/

import java.util.ArrayList;
import java.util.List;

/* ---- Abstract Job Role ---- */

abstract class JobRole {

    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

/* ---- Specific Job Roles ---- */

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

/* ---- Generic Resume Class ---- */

class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    // Method to display resume details
    public void displayResume() {
        System.out.println(candidateName + " applied for " + jobRole.getRoleName());
    }

    public T getJobRole() {
        return jobRole;
    }
}

/* ---- Screening Service ---- */

class ScreeningService {

    // Generic method to process resume
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume for " + resume.getJobRole().getRoleName());
    }

    // Wildcard method to screen multiple roles
    public static void screeningPipeline(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("AI Screening started for role: " + role.getRoleName());
        }
    }
}

/* ---- Main Class ---- */

public class ResumeScreening {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>("Alice", new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>("Bob", new DataScientist());

        r1.displayResume();
        r2.displayResume();

        ScreeningService.processResume(r1);
        ScreeningService.processResume(r2);

        List<SoftwareEngineer> seRoles = new ArrayList<>();
        seRoles.add(new SoftwareEngineer());

        ScreeningService.screeningPipeline(seRoles);

    }
}

