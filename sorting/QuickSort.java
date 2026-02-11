package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr,int leftInd,int rightInd){
        int temp=arr[leftInd];
        arr[leftInd]=arr[rightInd];
        arr[rightInd]=temp;
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int leftind=low;
        int rightind=high;

        while(leftind<rightind){
          while (arr[leftind]<=pivot && leftind<rightind){
              leftind++;
          }
          while(arr[rightind]>=pivot && leftind<rightind){
              rightind--;
          }
          swap(arr,leftind,rightind);
        }
        swap(arr,leftind,high);
        return leftind;
    }
    public static void quicksort(int[] arr,int low,int high){
        if (low < high) {
            int partitionInd=partition(arr,low,high);

            quicksort(arr,low,partitionInd-1);
            quicksort(arr,partitionInd+1,high);

        }

    }
    public static void main(String[] args) {
        int[] arr={8,4,7,3,6};
        quicksort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


}
