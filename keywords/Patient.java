/*
Create a Patient class with the following features:
Static:
A static variable hospitalName shared among all patients.
A static method getTotalPatients() to count the total patients admitted.
This:
Use this to initialize name, age, and ailment in the constructor.
Final:
Use a final variable patientID to uniquely identify each patient.
Instanceof:
Check if an object is an instance of the Patient class before displaying its details.
 */


class Patient{
    //Static variables
    static String hospitalName="SRM Hospital";
    static int patientCount=0;
    
    //Instance variables
    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    //Static method to show total patients
    static void getTotalPatients(){
        System.out.println("Total Patient Count: "+patientCount);
    }
    
    //Constructor using this keyword
    Patient(String name,int age,String ailment,int patientID){
        this.name=name;
        this.age=age;
        this.ailment=ailment;
        this.patientID=patientID;
        patientCount++;
    }
    
    //Static method to show patient details
    static void patientDetails(Object obj){
        if(obj instanceof Patient){
            Patient pt1=(Patient) obj;
            System.out.println("Patient name:"+pt1.name);
            System.out.println("Patient age: "+pt1.age);
            System.out.println("Patient ailment: "+pt1.ailment);
            System.out.println("Patient ID: "+pt1.patientID);
        }
    }
    public static void main(String[] args){
        Patient pt1=new Patient("Mohan",53,"cold",555);
        
        patientDetails(pt1);
        getTotalPatients();
        
    }
}