/*Write a program calculate the wind chill temperature given the temperature and wind speed
Hint => 
Write a method to calculate the wind chill temperature using the formula 
windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * windSpeed0.16 
public double calculateWindChill(double temperature, double windSpeed)
 */
import java.util.Scanner;

class WindChill {

    // Method to calculate wind chill based on temperature and wind speed
    public double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature +
                (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read temperature and wind speed
        double temprature = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        
        // Create object of WindChill class
        WindChill obj = new WindChill();

        // Calculate wind chill
        double windChill = obj.calculateWindChill(temprature, windSpeed);

        // Display wind chill value
        System.out.println(windChill);
    }
}
