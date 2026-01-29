package level2;

import java.util.Scanner;

class VotingSystem {

    static int[] generateAges(int n){
        int[] ages=new int[n];
        for(int i=0;i<n;i++){
            ages[i]=(int)(Math.random()*90); // random age
        }
        return ages;
    }

    static String[][] canVote(int[] ages){
        String[][] data=new String[ages.length][2];

        for(int i=0;i<ages.length;i++){
            data[i][0]=String.valueOf(ages[i]);
            if(ages[i]<0)
                data[i][1]="false";
            else if(ages[i]>=18)
                data[i][1]="true";
            else
                data[i][1]="false";
        }
        return data;
    }

    static void display(String[][] data){
        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");
        for(int i=0;i<data.length;i++){
            System.out.println(data[i][0]+"\t"+data[i][1]);
        }
    }

    public static void main(String[] args){
        int[] ages = generateAges(10);
        String[][] table = canVote(ages);
        display(table);
    }
}

