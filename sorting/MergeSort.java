package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] leftArr=new int[n1];
        int[] rightArr=new int[n2];

        System.arraycopy(arr,left,leftArr,0,n1);
        System.arraycopy(arr,mid+1,rightArr,0,n2);

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(leftArr[i]<rightArr[j]){
                arr[k++]=leftArr[i++];
            }else{
                arr[k++]=rightArr[j++];
            }
        }
        while(i<n1) arr[k++]=leftArr[i++];
        while(j<n2) arr[k++]=rightArr[j++];
    }
    public static void mergeSort(int[] arr,int left,int right) {

        if(left<right){
            int mid=left+(right-left)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }
    public static void main(String[] args) {
        int[] bookPrice={45,215,199,75};

        mergeSort(bookPrice,0,bookPrice.length-1);
        System.out.println(Arrays.toString(bookPrice));
    }
}
