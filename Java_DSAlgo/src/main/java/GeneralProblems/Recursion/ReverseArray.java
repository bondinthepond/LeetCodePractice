package GeneralProblems.Recursion;

public class ReverseArray {
    public String reverseRecursively(String str){
        if(str.isEmpty()) return str;
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    public String reverseIteratively(String str){
        String reverse = "";
        if(str.isEmpty()) { return str; }
        else {
            char[] ch = str.toCharArray();
            for(int i = ch.length-1; i>=0; i--){
                reverse += ch[i];
            }
        }
        return reverse;
    }

    public String reverseUsingStringBuilder(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
