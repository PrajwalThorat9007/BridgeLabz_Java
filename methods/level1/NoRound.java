/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;
class NoRound{

    void Rounds(int side1,int side2,int side3){
        int round=side1+side2+side3;
        int noRound=round/5;
        if(noRound<=0){
            System.out.println("No need to Run");
        }
        else{
            System.out.println(noRound);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int side1=sc.nextInt();
        int side2=sc.nextInt();
        int side3=sc.nextInt();

        NoRound obj=new NoRound();
        obj.Rounds(side1, side2, side3);
    }
}