/*
Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
Hint => 
Spring Season is from March 20 to June 20
*/

import java.util.Scanner;

class SpringSeason{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        int date=sc.nextInt();
        if((month==3 && date>=20)||month==4||month==5||(month==6 && date<=20)){
            System.out.println("It's Spring season");
        }else{
            System.out.println("It's not Spring season");
        }
    }
}