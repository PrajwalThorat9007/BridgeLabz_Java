package level3;

// Question: Write a program to find frequency using nested loops.

import java.util.Scanner;

class FrequencyNested {

    static String[] frequency(String text){
        char[] arr = text.toCharArray();
        int[] freq = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            freq[i]=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    freq[i]++;
                    arr[j]='0'; // mark duplicate
                }
            }
        }

        String[] result = new String[arr.length];
        int idx=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!='0'){
                result[idx++] = arr[i]+" : "+freq[i];
            }
        }

        String[] finalRes = new String[idx];
        for(int i=0;i<idx;i++) finalRes[i]=result[i];

        return finalRes;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        String[] res = frequency(text);

        System.out.println("\nChar : Frequency");
        System.out.println("------------------");
        for(String s: res){
            System.out.println(s);
        }
    }
}


