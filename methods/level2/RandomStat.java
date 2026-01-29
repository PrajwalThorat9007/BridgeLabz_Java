/*Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
Hint => 
Write a method that generates array of 4 digit random numbers given the size as a parameter as shown in the method signature 
public int[] generate4DigitRandomArray(int size)
Write a method to find average, min and max value of an array 
public double[] findAverageMinMax(int[] numbers)  */
class RandomStats {

    // Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            // Generates random 4-digit number (1000–9999)
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    // Method to find average, min, and max
    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = (double) sum / numbers.length;

        return new double[] { average, min, max };
    }

    public static void main(String[] args) {

        int[] randomNumbers = generate4DigitRandomArray(5);

        System.out.println("Generated Numbers:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }

        System.out.println();

        double[] result = findAverageMinMax(randomNumbers);

        System.out.println("Average = " + result[0]);
        System.out.println("Minimum = " + result[1]);
        System.out.println("Maximum = " + result[2]);
    }
}
