package linearandbinarysearch;

import org.w3c.dom.ls.LSOutput;

import javax.swing.plaf.IconUIResource;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] arr={45,65,88,97,25,33};

        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        System.out.println(arr[left]);
    }
}
