package level2;

import java.util.Scanner;

class RPSGame {

    static String computerChoice(){
        int r=(int)(Math.random()*3);
        if(r==0) return "rock";
        if(r==1) return "paper";
        return "scissors";
    }

    static String winner(String user,String comp){
        if(user.equals(comp)) return "Draw";

        if(user.equals("rock") && comp.equals("scissors")) return "User";
        if(user.equals("rock") && comp.equals("paper")) return "Computer";

        if(user.equals("paper") && comp.equals("rock")) return "User";
        if(user.equals("paper") && comp.equals("scissors")) return "Computer";

        if(user.equals("scissors") && comp.equals("paper")) return "User";
        if(user.equals("scissors") && comp.equals("rock")) return "Computer";

        return "Invalid";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n=sc.nextInt();

        int userWin=0, compWin=0;

        System.out.println("\nGame\tUser\tComputer\tWinner");
        System.out.println("--------------------------------------");

        for(int i=1;i<=n;i++){
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user=sc.next().toLowerCase();
            String comp=computerChoice();
            String win=winner(user,comp);

            if(win.equals("User")) userWin++;
            if(win.equals("Computer")) compWin++;

            System.out.println(i+"\t"+user+"\t"+comp+"\t\t"+win);
        }

        double userPer = (userWin*100.0)/n;
        double compPer = (compWin*100.0)/n;

        System.out.println("\nUser Wins: "+userWin);
        System.out.println("Computer Wins: "+compWin);
        System.out.println("User %: "+userPer);
        System.out.println("Computer %: "+compPer);
    }
}
