package level3;

// Question: Write a program to check palindrome using 3 logics.

import java.util.Scanner;

class PalindromeMain {

    static boolean loopCheck(String t){
        int s=0,e=t.length()-1;
        while(s<e){
            if(t.charAt(s)!=t.charAt(e)) return false;
            s++; e--;
        }
        return true;
    }

    static boolean recursionCheck(String t,int s,int e){
        if(s>=e) return true;
        if(t.charAt(s)!=t.charAt(e)) return false;
        return recursionCheck(t,s+1,e-1);
    }

    static char[] reverse(String t){
        char[] r=new char[t.length()];
        int k=0;
        for(int i=t.length()-1;i>=0;i--){
            r[k++]=t.charAt(i);
        }
        return r;
    }

    static boolean arrayCheck(String t){
        char[] o=t.toCharArray();
        char[] r=reverse(t);
        for(int i=0;i<o.length;i++){
            if(o[i]!=r[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=sc.nextLine();

        System.out.println("Loop Logic: "+loopCheck(text));
        System.out.println("Recursion Logic: "+recursionCheck(text,0,text.length()-1));
        System.out.println("Array Logic: "+arrayCheck(text));
    }
}

