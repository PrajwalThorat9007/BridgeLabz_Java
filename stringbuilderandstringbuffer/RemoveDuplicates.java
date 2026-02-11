package stringbuilderandstringbuffer;
import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicate(String str){
        StringBuilder ans=new StringBuilder();
        HashSet<Character> set=new HashSet<>();

        for(char ch:str.toCharArray()){
            if(!set.contains(ch)){
                ans.append(ch);
                set.add(ch);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String str="Generator";

        System.out.println(removeDuplicate(str));
    }
}
