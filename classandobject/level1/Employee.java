import java.util.Scanner;
class Employee{
    private String name;
    private int id;
    private int salary;
    
    public void setData(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    public void getData(){
        System.out.println("Employee name is "+name+" id is "+id+" and salary is "+salary);
    }
    
    public static void main(String[] args){
        Employee emp1=new Employee();
        Scanner sc=new Scanner(System.in);
        
        String name=sc.next();
        int id=345;
        int salary=1500000;
        
        emp1.setData(name,id,salary);
        emp1.getData();
    }
}
