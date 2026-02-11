package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {

        String target="Java";
        int counter=0;
        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\BridgeLabz_Java\\FileReading\\data.txt"))){
            String line;
            while((line=reader.readLine())!=null){
                String[] words=line.split("\\s+");
                for(String word:words){
                    if(word.equals(target)){
                        counter++;
                    }
                }
            }
            System.out.println("The word "+target+" occured "+counter+" times");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
