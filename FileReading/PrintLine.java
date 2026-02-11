package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintLine {
    public static void main(String[] args) {

        try (BufferedReader bfReader =
                     new BufferedReader(new FileReader("C:\\BridgeLabz_Java\\FileReading\\data.txt"))) {

            String line;
            while ((line = bfReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

