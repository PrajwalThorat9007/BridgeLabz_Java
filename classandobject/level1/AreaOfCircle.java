import java.util.Scanner;

class AreaOfCircle{
    private int radius;
    
    public double Area(int radius){
        double area=Math.PI*Math.pow(radius,2);
        return area;
    }
    
    public double Circumference(int radius){
        double circumference=2*Math.PI*radius;
        return circumference;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int radius=sc.nextInt();
        
        AreaOfCircle obj=new AreaOfCircle();
        double A=obj.Area(radius);
        double C=obj.Circumference(radius);
        
        System.out.println("Area of Circle "+A+" and circumference is "+C);
    }
}