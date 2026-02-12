package runtimeanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReadPerformanceComparison {
    // Using FileReader
    public static void testFileReader(String filePath) {

        long startTime = System.nanoTime();
        long charCount = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            char[] buffer = new char[8192];
            int read;

            while ((read = br.read(buffer)) != -1) {
                charCount += read;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("FileReader:");
        System.out.println("Characters Read: " + charCount);
        System.out.println("Time Taken: " +
                (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // Using InputStreamReader
    public static void testInputStreamReader(String filePath) {

        long startTime = System.nanoTime();
        long charCount = 0;

        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(filePath)))) {

            char[] buffer = new char[8192];
            int read;

            while ((read = br.read(buffer)) != -1) {
                charCount += read;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("InputStreamReader:");
        System.out.println("Characters Read: " + charCount);
        System.out.println("Time Taken: " +
                (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {

        String filePath = "largefile.txt";  // 500MB test file
        System.out.println("Reading file: " + filePath);

        testFileReader(filePath);
        testInputStreamReader(filePath);
    }
}
