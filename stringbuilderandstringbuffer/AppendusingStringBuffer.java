package stringbuilderandstringbuffer;

public class AppendusingStringBuffer {
    public static String appendArray(String[] arr){
        StringBuffer sb=new StringBuffer();
        for(String str:arr){
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] arr={"Hello","my","name","is","java"};

        System.out.println(appendArray(arr));
    }
}
