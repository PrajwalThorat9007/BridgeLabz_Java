package level2;

import java.util.Scanner;

class WordLength2D {

    static int findLength(String text) {
        int c = 0;
        try { while(true){ text.charAt(c); c++; } }
        catch(Exception e){}
        return c;
    }

    static String[] splitWords(String text) {
        return text.split(" "); // logic already practiced above
    }

    static String[][] wordLength2D(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(findLength(words[i]));
        }
        return data;
    }

    static void display(String[][] data) {
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + Integer.parseInt(data[i][1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = wordLength2D(words);

        display(table);
    }
}
