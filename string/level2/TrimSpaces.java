package level2;

import java.util.Scanner;

class TrimSpaces {

    static int[] findTrimPoints(String text){
        int start=0, end=text.length()-1;

        while(text.charAt(start)==' ') start++;
        while(text.charAt(end)==' ') end--;

        return new int[]{start,end+1};
    }

    static String substring(String text,int s,int e){
        String res="";
        for(int i=s;i<e;i++){
            res+=text.charAt(i);
        }
        return res;
    }

    static boolean compare(String a,String b){
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text=sc.nextLine();

        int[] p = findTrimPoints(text);
        String userTrim = substring(text,p[0],p[1]);
        String builtInTrim = text.trim();

        boolean result = compare(userTrim,builtInTrim);

        System.out.println("User Trim: ["+userTrim+"]");
        System.out.println("Built-in Trim: ["+builtInTrim+"]");
        System.out.println("Comparison Result: "+result);
    }
}

