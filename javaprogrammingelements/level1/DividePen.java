/*
Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed pens.
Hint => 
Use Modulus Operator (%) to find the reminder.
Use Division Operator to find the Quantity of pens
I/P => NONE
O/P => The Pen Per Student is ___ and the remaining pen not distributed is ___
*/
class DividePen{
    public static void main(String[] args){
        int noPen=13;
        int noStudent=3;
        
        int remainning = noPen%noStudent;
        int each=noPen/noStudent;
        
        System.out.println("The Pen Per Student is "+each+" and the remaining pen not distributed is "+remainning);
    }
}