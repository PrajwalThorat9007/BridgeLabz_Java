package linearandbinarysearch;

import java.util.Scanner;

public class NegativeNumber {
    public static void main(String[] args) {
        int[] arr={45,53,66,99,73,22};
        boolean found=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int target=sc.nextInt();
        int index=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                found=true;
                index=i;
            }
        }
        if(!found){
            System.out.println(-1);
        }else {
            System.out.println("Number found at: "+index);
        }
    }

}
