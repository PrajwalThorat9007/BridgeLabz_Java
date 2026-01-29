package level3;

// Question: Write a program to find the first non-repeating character.

import java.util.Scanner;

class FirstNonRepeating {

    static char firstNonRepeat(String text){
        int[] freq = new int[256];

        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)]++;
        }

        for(int i=0;i<text.length();i++){
            if(freq[text.charAt(i)] == 1){
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        char res = firstNonRepeat(text);

        if(res=='\0')
            System.out.println("No non-repeating character");
        else
            System.out.println("First Non-Repeating Character: " + res);
    }
}


