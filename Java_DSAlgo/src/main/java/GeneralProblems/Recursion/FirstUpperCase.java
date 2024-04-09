package GeneralProblems.Recursion;

public class FirstUpperCase {

    public char findFirstUpperCase(String str) {

        if(str.length() == 0){
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        } else if (Character.isLowerCase(str.charAt(0))) {
            return findFirstUpperCase(str.substring(1));
        }
        return 0;
    }
}
