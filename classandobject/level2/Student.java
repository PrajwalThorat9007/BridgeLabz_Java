class Student{
    int rollNumber;
    int marks;
    String name;
    
    Student(int rollNumber,int marks, String name){
        this.rollNumber=rollNumber;
        this.marks=marks;
        this.name=name;
    }
    
    void Grade(int marks){
        if(marks<50){
            System.out.println("low");
        }
        else if(marks>=50 && marks<75){
            System.out.println("Good");
        }
        else{
            System.out.println("Excellent");
        }
    }
    
    void getData(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+rollNumber);
        System.out.println("Marks: "+marks);
    }
    
    public static void main(String[] args){
        Student std1=new Student(345,97,"Raju");
        std1.getData();
        std1.Grade(97);
    }
}