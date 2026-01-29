/*Write a program calculate the wind chill temperature given the temperature and wind speed
Hint => 
Write a method to calculate the wind chill temperature using the formula 
windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * windSpeed0.16 
public double calculateWindChill(double temperature, double windSpeed)
 */
import java.util.Scanner;

class WindChill{
    public double calculateWindChill(double temperature, double windSpeed){
        double windChill=35.74+0.6215* temperature+(0.4275* temperature-35.75)*Math.pow(windSpeed,0.16);
        return windChill;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        double temprature=sc.nextDouble();
        double windSpeed=sc.nextDouble();
        
        WindChill obj=new WindChill();
        double windChill=obj.calculateWindChill(temprature,windSpeed);
        System.out.println(windChill);
        
    }
}