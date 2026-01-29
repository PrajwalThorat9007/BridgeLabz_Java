package level3;

// Question: Write a program to find character frequency using unique characters.

import java.util.Scanner;

class FrequencyUnique {

    static char[] uniqueChars(String text){
        char[] temp = new char[text.length()];
        int count = 0;

        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            boolean unique = true;

            for(int j=0;j<i;j++){
                if(text.charAt(j)==ch){
                    unique=false;
                    break;
                }
            }

            if(unique){
                temp[count++] = ch;
            }
        }

        char[] res = new char[count];
        for(int i=0;i<count;i++) res[i]=temp[i];
        return res;
    }

    static String[][] frequency(String text){
        int[] freq = new int[256];

        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)]++;
        }

        char[] unique = uniqueChars(text);
        String[][] result = new String[unique.length][2];

        for(int i=0;i<unique.length;i++){
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
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

