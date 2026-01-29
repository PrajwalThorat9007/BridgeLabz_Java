package level2;

import java.util.Scanner;

class ShortLong {

    static String[] splitWords(String text){
        return text.split(" ");
    }

    static int length(String s){
        int c=0; try{while(true){s.charAt(c);c++;}}catch(Exception e){}
        return c;
    }

    static int[] findShortLong(String[] words){
        int min = 0, max = 0;
        for(int i=1;i<words.length;i++){
            if(length(words[i]) < length(words[min])) min=i;
            if(length(words[i]) > length(words[max])) max=i;
        }
        return new int[]{min,max};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String text=sc.nextLine();

        String[] words=splitWords(text);
        int[] idx=findShortLong(words);

        System.out.println("Shortest word: " + words[idx[0]]);
        System.out.println("Longest word: " + words[idx[1]]);
    }
}

