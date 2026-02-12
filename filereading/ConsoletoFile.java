package filereading;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoletoFile {
    public static void main(String[] args) {
        try(
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                FileWriter fw=new FileWriter("C:\\BridgeLabz_Java\\FileReading\\output.txt");
        ){
            String line;
            System.out.println("Type exit to end: ");
            while(true) {
                line = br.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(line);
                fw.write(System.lineSeparator());
            }
            System.out.println("Data written");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
