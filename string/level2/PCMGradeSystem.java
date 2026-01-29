package level2;

import java.util.Scanner;

class PCMGradeSystem {

    // Generate random 2-digit PCM scores
    static int[][] generatePCM(int n){
        int[][] pcm = new int[n][3];

        for(int i=0;i<n;i++){
            pcm[i][0] = 10 + (int)(Math.random()*90); // Physics
            pcm[i][1] = 10 + (int)(Math.random()*90); // Chemistry
            pcm[i][2] = 10 + (int)(Math.random()*90); // Maths
        }
        return pcm;
    }

    // Calculate total, average, percentage
    static double[][] calculateStats(int[][] pcm){
        int n = pcm.length;
        double[][] stats = new double[n][3]; // total, avg, percent

        for(int i=0;i<n;i++){
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            avg = Math.round(avg * 100.0) / 100.0;
            percent = Math.round(percent * 100.0) / 100.0;

            stats[i][0] = total;
            stats[i][1] = avg;
            stats[i][2] = percent;
        }
        return stats;
    }

    // Grade calculation based on image table
    static String[] calculateGrade(double[][] stats){
        int n = stats.length;
        String[] grade = new String[n];

        for(int i=0;i<n;i++){
            double p = stats[i][2];

            if(p >= 80) grade[i] = "A";
            else if(p >= 70) grade[i] = "B";
            else if(p >= 60) grade[i] = "C";
            else if(p >= 50) grade[i] = "D";
            else if(p >= 40) grade[i] = "E";
            else grade[i] = "R";
        }
        return grade;
    }

    // Display marksheet
    static void display(int[][] pcm, double[][] stats, String[] grade){
        System.out.println("\n================ STUDENT SCORECARD ================");
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("---------------------------------------------------");

        for(int i=0;i<pcm.length;i++){
            System.out.println(
                    (i+1)+"\t"+
                            pcm[i][0]+"\t"+
                            pcm[i][1]+"\t"+
                            pcm[i][2]+"\t"+
                            (int)stats[i][0]+"\t"+
                            stats[i][1]+"\t"+
                            stats[i][2]+"\t"+
                            grade[i]
            );
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] pcm = generatePCM(n);
        double[][] stats = calculateStats(pcm);
        String[] grade = calculateGrade(stats);

        display(pcm, stats, grade);
    }
}

