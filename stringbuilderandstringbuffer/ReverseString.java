package stringbuilderandstringbuffer;

public class ReverseString {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();

        sb.append("hello");
        sb.reverse();

        System.out.println(sb.toString());

    }

}
