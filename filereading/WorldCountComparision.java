package filereading;

import java.io.*;

public class WorldCountComparision {

    public static void main(String[] args) {

        String fileName ="C:\\BridgeLabz_Java\\FileReading\\data.txt";

        // ==============================
        // 1️⃣ Using FileReader
        // ==============================
        long startTime1 = System.currentTimeMillis();
        long wordCount1 = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    wordCount1 += words.length;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime1 = System.currentTimeMillis();

        System.out.println("Using FileReader:");
        System.out.println("Word Count = " + wordCount1);
        System.out.println("Time Taken = " +
                (endTime1 - startTime1) + " ms");

        System.out.println("-----------------------------------");

        // ==============================
        // 2️⃣ Using InputStreamReader
        // ==============================
        long startTime2 = System.currentTimeMillis();
        long wordCount2 = 0;

        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(fileName)))) {

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    wordCount2 += words.length;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime2 = System.currentTimeMillis();

        System.out.println("Using InputStreamReader:");
        System.out.println("Word Count = " + wordCount2);
        System.out.println("Time Taken = " +
                (endTime2 - startTime2) + " ms");
    }
}

