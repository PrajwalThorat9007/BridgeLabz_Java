package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int size=arr.length;

        for(int i=1;i<size;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int[] employeeID={333,223,115,555,456};

        insertionSort(employeeID);
        System.out.println(Arrays.toString(employeeID));
    }
}
