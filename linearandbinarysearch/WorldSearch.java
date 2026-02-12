package linearandbinarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WorldSearch {
    public static boolean wordSearch(String[] words,String target){
        target=target.toLowerCase();
        for(String word:words){
            if(word.equals(target)){
                return true;
            }
        }
        return false;
    }
    public static String readWord(String filePath,String target){
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
           String line;
           while((line=br.readLine())!=null){
                line=line.toLowerCase().replaceAll("[^a-zA-Z]","");
               String[] words=line.split("\\s+");
               boolean wordPresent=wordSearch(words,target);
               if(wordPresent){
                   return line;
               }
           }
           return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String filePath="C:\\BridgeLabz_Java\\linearandbinarysearch\\test.txt";
        String target="java";

        String wordinLine=readWord(filePath,target);
        if(wordinLine==null){
            System.out.println("Error reading the file");
            return;
        }else {
            System.out.println(wordinLine);
        }
    }

}
