package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int size=arr.length;
        boolean swap;
        for(int i=0;i<size;i++){
            swap=false;

            for(int j=0;j<size-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    swap=true;
                }
            }
            if(!swap) break;
        }
    }
    public static void main(String[] args) {
        int[] marks={97,92,87,94,83};

        bubbleSort(marks);
        System.out.println(Arrays.toString(marks));
    }
}
