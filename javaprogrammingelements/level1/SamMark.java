/*
Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM
I/P => NONE
O/P => Sam’s average mark in PCM is ___ 
*/
class SamMark {
    public static void main(String[] args) {

        // Marks obtained in subjects
        int Maths = 94;
        int Physics = 95;
        int Chemistry = 96;
        
        // Calculate average marks
        double average = (Maths + Physics + Chemistry) / 3.0;

        // Display the average marks
        System.out.println("Sam average mark in PCM is " + average);
    }
}
