package level3;

// Question: Find unique characters in a string using charAt().

import java.util.Scanner;

class UniqueCharacters {

    static int findLength(String text){
        int c=0; try{while(true){text.charAt(c);c++;}}catch(Exception e){}
        return c;
    }

    static char[] uniqueChars(String text){
        int len = findLength(text);
        char[] temp = new char[len];
        int count = 0;

        for(int i=0;i<len;i++){
            char ch = text.charAt(i);
            boolean isUnique = true;

            for(int j=0;j<i;j++){
                if(text.charAt(j)==ch){
                    isUnique=false;
                    break;
                }
            }

            if(isUnique){
                temp[count++] = ch;
            }
        }

        char[] result = new char[count];
        for(int i=0;i<count;i++){
            result[i]=temp[i];
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        char[] unique = uniqueChars(text);

        System.out.print("Unique Characters: ");
        for(char c: unique){
            System.out.print(c+" ");
        }
    }
}

