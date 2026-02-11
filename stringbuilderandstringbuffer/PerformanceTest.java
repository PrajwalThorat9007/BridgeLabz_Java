package stringbuilderandstringbuffer;

public class PerformanceTest {
    public static void main(String[] args) {
        long startTime,endTime;

        startTime=System.nanoTime();
        StringBuilder sb=new StringBuilder("Test");
        for(int i=0;i<1000000;i++){
            sb.append(" test");
        }
        endTime=System.nanoTime();
        System.out.println("For StringBuilder: ");
        System.out.println("Start Time: "+startTime);
        System.out.println("End Time: "+endTime);
        System.out.println("Time Taken: "+(endTime-startTime));


        startTime=System.nanoTime();
        StringBuffer sb1=new StringBuffer("test");
        for(int i=0;i<1000000;i++){
            sb.append(" test");
        }
        endTime=System.nanoTime();
        System.out.println();
        System.out.println("For StringBuffer: ");
        System.out.println("Start Time: "+startTime);
        System.out.println("End Time: "+endTime);
        System.out.println("Time Taken: "+(endTime-startTime));
    }
}
