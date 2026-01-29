package level2;

import java.util.Scanner;

class VowelConsonantCount {

    static String checkChar(char ch){
        // convert to lowercase using ASCII
        if(ch >= 'A' && ch <= 'Z'){
            ch = (char)(ch + 32);
        }

        if(ch >= 'a' && ch <= 'z'){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static int[] countVC(String text){
        int v=0,c=0;
        for(int i=0;i<text.length();i++){
            String type = checkChar(text.charAt(i));
            if(type.equals("Vowel")) v++;
            else if(type.equals("Consonant")) c++;
        }
        return new int[]{v,c};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        int[] res = countVC(text);

        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
    }
}

