package level3;

// Question: Write a program to find the frequency of characters in a string using ASCII array.

import java.util.Scanner;

class CharFrequencyASCII {

    static String[][] frequency(String text){
        int[] freq = new int[256];

        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)]++;
        }

        int count = 0;
        for(int i=0;i<256;i++){
            if(freq[i] > 0) count++;
        }

        String[][] result = new String[count][2];
        int idx = 0;

        for(int i=0;i<256;i++){
            if(freq[i] > 0){
                result[idx][0] = String.valueOf((char)i);
                result[idx][1] = String.valueOf(freq[i]);
                idx++;
            }
        }
        return result;
    }

    static void display(String[][] data){
        System.out.println("\nChar\tFrequency");
        System.out.println("-----------------");
        for(int i=0;i<data.length;i++){
            System.out.println(data[i][0]+"\t"+data[i][1]);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        String[][] res = frequency(text);
        display(res);
    }
}


