package sorting;

public class CountSort {

    public static void main(String[] args) {

        // Student ages (initialized)
        int[] ages = {18, 21, 20, 19, 18, 22, 21, 20};

        // Assuming age range: 18 to 22
        countingSort(ages, 18, 22);

        // Print sorted ages
        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }

    // Counting Sort method
    public static void countingSort(int[] arr, int minAge, int maxAge) {

        int range = maxAge - minAge + 1;
        int[] count = new int[range];

        // Step 1: Count frequency of each age
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Step 2: Reconstruct sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + minAge;
                count[i]--;
            }
        }
    }
}

